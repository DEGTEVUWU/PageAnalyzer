package hexlet.code.controllers;

import hexlet.code.model.UrlCheck;
import hexlet.code.repository.CheckRepository;
import hexlet.code.repository.UrlRepository;
import hexlet.code.utils.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.InternalServerErrorResponse;
import io.javalin.http.NotFoundResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.jsoup.Jsoup;

import java.sql.SQLException;
import hexlet.code.utils.CurrentTime;

public class CheckController {
    public static void check(Context ctx) throws SQLException {
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

            var currentTime = CurrentTime.currentTime();
            UrlCheck urlCheck = new UrlCheck(statusCode, title, h1, description, urlId, currentTime);
            try {
                CheckRepository.saveCheck(urlCheck);
            } catch (SQLException e) {
                throw new InternalServerErrorResponse();
            }

            ctx.sessionAttribute("flash", "Страница успешно проверена");
            ctx.sessionAttribute("flashType", "success");
        } catch (UnirestException  e) {
            ctx.sessionAttribute("flash", "Некорректный адрес");
            ctx.sessionAttribute("flashType", "danger");
        }
        ctx.redirect(NamedRoutes.urlPath(url.getId()));
    }
}
