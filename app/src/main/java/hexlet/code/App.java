package hexlet.code;

import io.javalin.Javalin;

import java.io.IOException;
import java.sql.SQLException;

public class App {
    public static Javalin getApp() {
        var app = Javalin.create(/*config*/)
                .get("/", ctx -> ctx.result("Hello World"));
        return app;
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
