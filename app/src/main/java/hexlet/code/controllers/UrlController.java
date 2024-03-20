package hexlet.code.controllers;

import hexlet.code.dto.BuildUrlPage;
import hexlet.code.dto.UrlPage;
import hexlet.code.dto.UrlsPage;
import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;
import hexlet.code.repository.CheckRepository;
import hexlet.code.repository.UrlRepository;
import hexlet.code.utils.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.apache.commons.validator.routines.UrlValidator;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UrlController {
    public static void root(Context ctx) {
        ctx.render("index.jte");
        ctx.consumeSessionAttribute("flash");
        ctx.consumeSessionAttribute("errorFlash");
    }
    public static void index(Context ctx) throws SQLException {
        List<Url> urls = UrlRepository.getEntities();

        UrlsPage page = new UrlsPage(urls);

        //вывод флеш сообщений о (не)добавлении сайта
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setFlashType(ctx.consumeSessionAttribute("flashType"));

        ctx.render("urls/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        Url url = UrlRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));

        if (CheckRepository.findExisting(url.getId())) {
            List<UrlCheck> listWithChecks = new ArrayList<>();
            listWithChecks = CheckRepository.find(Math.toIntExact(url.getId()));
            UrlPage page = new UrlPage(url, listWithChecks);
            ctx.render("urls/show.jte", Collections.singletonMap("page", page));
        } else {
            UrlPage page = new UrlPage(url, null);
            ctx.render("urls/show.jte", Collections.singletonMap("page", page));
        }
//        UrlPage page = new UrlPage(url, null);
//        ctx.render("urls/show.jte", Collections.singletonMap("page", page));
    }


    public static void create(Context ctx) throws SQLException, URISyntaxException, MalformedURLException {
        var beginnerUrl = ctx.formParam("url");

        try {
            var uri = new URI(beginnerUrl);
            String name = uri.getScheme() + "://" + uri.getAuthority();

//            uri.toURL();

            if (!validateUrl(name)) {
                ctx.sessionAttribute("flash", "Некорректный URL");
                ctx.sessionAttribute("flashType", "danger");
                var page = new BuildUrlPage();
                page.setFlash(ctx.consumeSessionAttribute("flash"));
                page.setFlashType(ctx.consumeSessionAttribute("flashType"));
                ctx.render("index.jte", Collections.singletonMap("page", page));
                return;
            }
            if (UrlRepository.findExisting(name)) {
                ctx.sessionAttribute("flash", "Страница уже существует");
                ctx.sessionAttribute("flashType", "info");
                ctx.redirect(NamedRoutes.urlsPath());
            } else {
                //добавить в объект класса урл приведённую к нужному виду ссыль-имя сайта,
                // с кем мы работаем, записать в бд
                Url resultUrl = new Url(name);
                UrlRepository.save(resultUrl);

                ctx.sessionAttribute("flash", "Страница успешно добавлена");
                ctx.sessionAttribute("flashType", "success");

                ctx.redirect(NamedRoutes.urlsPath());
            }

        } catch (ValidationException e) {
            var page = new BuildUrlPage(beginnerUrl, e.getErrors());

            ctx.status(422).render("index.jte", Collections.singletonMap("page", page));
        }
    }
    public static boolean validateUrl(String url) {
        String[] schemas = {"http", "https"};
        UrlValidator validator = new UrlValidator(schemas, UrlValidator.ALLOW_LOCAL_URLS);
        return validator.isValid(url);
    }

}
