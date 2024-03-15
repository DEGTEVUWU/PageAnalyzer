package hexlet.code;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.ResourceCodeResolver;
import hexlet.code.controllers.UrlController;
import hexlet.code.repository.*;

import hexlet.code.utils.NamedRoutes;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.Javalin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;

@Slf4j

public class App {
    public static Javalin getApp() throws IOException, SQLException {
        //создали бд в памяти машины
        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(getDataBaseUrl());
        var dataSource = new HikariDataSource(hikariConfig);

        //Получаем путь до файла с базовыми sql-запросами по настройке таблиц в src/main/resources
        var url = App.class.getClassLoader().getResourceAsStream("schema.sql");
        var sql = new BufferedReader(new InputStreamReader(url))
                .lines().collect(Collectors.joining("\n"));
        log.info(sql);

        // Получаем соединение, создаем стейтмент и выполняем запрос
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }

        //объект - источник данных для будущего исп в классах-контролерах, где будут выполняться разные запросы в бд
        BaseRepository.dataSource = dataSource;

        //создать инстанс соединения и указать путь к jte-файлам для отрисовки
        var app = Javalin.create(config -> {
            config.fileRenderer(new JavalinJte(createTemplateEngine()));
        });


        //указываем запросы
        app.get(NamedRoutes.rootPath(), UrlController::root);
//        app.get(NamedRoutes.buildUrlsPath(), UrlController::build);
        app.post(NamedRoutes.urlsPath(), UrlController::create);
        app.get(NamedRoutes.urlsPath(), UrlController::index);
        app.get(NamedRoutes.urlPath("{id}"), UrlController::show);




        return app;
    }
        public static String getDataBaseUrl() {
        String url = System.getenv().getOrDefault("JDBC_DATABASE_URL",
                "jdbc:h2:mem:hexlet_project;DB_CLOSE_DELAY=-1;");
        return url;
    }

    public static int getPort() {
        String port = System.getenv().getOrDefault("PORT", "7070");
        return Integer.valueOf(port);
    }
    private static TemplateEngine createTemplateEngine() {
        ClassLoader classLoader = App.class.getClassLoader();
        ResourceCodeResolver codeResolver = new ResourceCodeResolver("templates", classLoader);
        TemplateEngine templateEngine = TemplateEngine.create(codeResolver, ContentType.Html);
        return templateEngine;
    }
    public static void main(String[] args) throws IOException, SQLException, Exception {
        Javalin app = getApp();
        app.start(getPort());
    }

}
