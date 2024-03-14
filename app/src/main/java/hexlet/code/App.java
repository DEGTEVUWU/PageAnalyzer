package hexlet.code;

import hexlet.code.repository.*;


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
public class App {
    public static Javalin getApp() throws SQLException {
        //создали бд в памяти машины
        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(getDataBaseUrl());
        var dataSource = new HikariDataSource(hikariConfig);

        // Получаем путь до файла с базовыми sql-запросами по настройке таблиц в src/main/resources
        var url = App.class.getClassLoader().getResourceAsStream("schema.sql");
        var sql = new BufferedReader(new InputStreamReader(url))
                .lines().collect(Collectors.joining("\n"));

        // Получаем соединение, создаем стейтмент и выполняем запрос
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }

        BaseRepository.dataSource = dataSource;
        //объект - источник данных для будущего исп в классах-контролерах, где будут выполняться разные запрсы в бд


        var app = Javalin.create(/*config*/)
                .get("/", ctx -> ctx.result("Hello World"));
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
    public static void main(String[] args) throws IOException, SQLException, Exception {
        Javalin app = getApp();
        app.start(getPort());
    }

}
