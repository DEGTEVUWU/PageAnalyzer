package hexlet.code.controllers;

import hexlet.code.dto.UrlPage;
import hexlet.code.model.UrlCheck;
import hexlet.code.repository.CheckRepository;
import hexlet.code.repository.UrlRepository;
import hexlet.code.utils.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.InternalServerErrorResponse;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import kong.unirest.Unirest;
import org.jsoup.Jsoup;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CheckController {
    public static void check(Context ctx) throws SQLException {
//        List<UrlCheck> list = new ArrayList<>();
        var urlId = ctx.pathParamAsClass("id", Long.class).get();
        var url = UrlRepository.find(urlId)
                .orElseThrow(() -> new NotFoundResponse("Entity with id " + urlId + " not found"));

        try {
            var response = Unirest.get(url.getName()).asString();
            Integer statusCode = response.getStatus();
            String body = response.getBody();

            var htmlPage = Jsoup.parse(body);
            String h1 = htmlPage.getElementsByTag("h1").text();
            String title = htmlPage.getElementsByTag("title").text();
            String description = htmlPage.select("meta[name = description]").attr("content");
            Date actualDate = new Date();
            Timestamp createdAt = new Timestamp(actualDate.getTime());

            UrlCheck urlCheck = new UrlCheck();
            urlCheck.setStatusCode(statusCode);
            urlCheck.setTitle(title);
            urlCheck.setH1(h1);
            urlCheck.setDescription(description);
            urlCheck.setUrlId(urlId);
            urlCheck.setCreatedAt(createdAt);
            try {
                CheckRepository.saveCheck(urlCheck);
            } catch (SQLException e) {
                throw new InternalServerErrorResponse();
            }

            ctx.sessionAttribute("flash", "Страница успешно проверена");
            ctx.sessionAttribute("flashType", "success");
        } catch (ValidationException e) {
            ctx.sessionAttribute("flash", "Некорректный адрес");
            ctx.sessionAttribute("flashType", "danger");
        }

        ctx.redirect(NamedRoutes.urlPath(url.getId()));
    }
}
