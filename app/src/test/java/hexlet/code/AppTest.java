package hexlet.code;

import static org.assertj.core.api.Assertions.assertThat;

import hexlet.code.model.Url;
import hexlet.code.repository.UrlRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class AppTest {
    Javalin app;

    @BeforeEach
    public final void setUp() throws IOException, SQLException {
        app = App.getApp();
    }

    @Test
    public void testMainPage() {
        JavalinTest.test(app, ((server, client) -> {
            var response = client.get("/");
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string().contains("Проверка сайтов на SEO-пригодность"));
        }));
    }

    @Test
    public void testUrlsPage() {
        JavalinTest.test(app, ((server, client) -> {
            var response = client.get("/urls");
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string().contains("Это лист со всеми добавленными сайтами!"));
        }));
    }

    @Test
    public void testSomeUrlPage() throws SQLException {
        Date actualDate = new Date();
        Timestamp createdAt = new Timestamp(actualDate.getTime());
        Url url = new Url("https://github.com/", createdAt);
        UrlRepository.save(url);
        //создали тестовый объект и закинули в БД

        JavalinTest.test(app, ((server, client) -> {
            var response = client.get("/url/" + url.getId());
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string().contains("github.com"));
        }));
    }

    @Test
    void testUrlNotFound() throws Exception {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/url/999999");
            assertThat(response.code()).isEqualTo(404);
        });
    }


}
