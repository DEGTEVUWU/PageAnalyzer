package hexlet.code;

import static org.assertj.core.api.Assertions.assertThat;

import hexlet.code.model.Url;
import hexlet.code.repository.CheckRepository;
import hexlet.code.repository.UrlRepository;
import hexlet.code.utils.NamedRoutes;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class AppTest {
    private Javalin app;
    private MockWebServer mockWebServer;

    @BeforeEach
    public final void setUp() throws IOException, SQLException {
        app = App.getApp();
        mockWebServer = new MockWebServer();
        mockWebServer.start(); //создал инстанс мок-серва и запустил его
    }


    @Test
    public void testMainPage() {
        JavalinTest.test(app, ((server, client) -> {
            var response = client.get("/");
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string().contains("Проверка сайтов на SEO-пригодность"));
            response.close();
        }));
    }

    @Test
    public void testUrlsPage() {
        JavalinTest.test(app, ((server, client) -> {
            var request = "url=https://github.com";
            client.post(NamedRoutes.urlsPath(), request);
            var response = client.get(NamedRoutes.urlsPath());

            var responseBody = response.body().toString();
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string().contains("Это лист со всеми добавленными сайтами!"));
            assertThat(UrlRepository.findExisting("https://github.com")).isTrue();
            assertThat(responseBody.contains("github.com"));
            response.close();
        }));
    }

    @Test
    public void testSomeUrlPage() throws SQLException {
        Date actualDate = new Date();
        Timestamp createdAt = new Timestamp(actualDate.getTime());
        Url url = new Url("https://github.com");
        url.setCreatedAt(createdAt);
        UrlRepository.save(url);
        //создали тестовый объект и закинули в БД

        JavalinTest.test(app, ((server, client) -> {
            var response = client.get("/urls/" + url.getId());
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string().contains("github.com"));
            assertThat(UrlRepository.findExisting("https://github.com")).isTrue();
            response.close();
        }));
    }
    @Test
    public void testSomeUrlCreate() {
        JavalinTest.test(app, ((server, client) -> {
            var requestBody = "url=https://github.com";
            var response = client.post(NamedRoutes.urlsPath(), requestBody);
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("github.com");
            assertThat(UrlRepository.findExisting("https://github.com")).isTrue();
        }));
    }
    @Test
    public void testSomeUrlCheck() throws SQLException {
        Date actualDate = new Date();
        Timestamp createdAt = new Timestamp(actualDate.getTime());
        Url url = new Url("https://github.com");
        url.setCreatedAt(createdAt);
        UrlRepository.save(url);
        //создали тестовый объект и закинули в БД

        JavalinTest.test(app, ((server, client) -> {
            var requestBody = "url=https://github.com";
            var response = client.post(NamedRoutes.checkPath(url.getId()), requestBody);
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("github.com");
            assertThat(UrlRepository.findExisting("https://github.com")).isTrue();
            assertThat(CheckRepository.findExisting(url.getId())).isTrue();
            assertThat(CheckRepository.find(Math.toIntExact(url.getId())).get(0).getTitle())
                    .isEqualTo("GitHub: Let’s build from here · GitHub");
        }));
    }

    @Test
    void testUrlNotFound() throws SQLException {
        UrlRepository.delete(999999L);
        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/urls/999999");
            assertThat(response.code()).isEqualTo(404);

        });
    }
    @Test
    void testMockWebServer() throws IOException {
        String body = Files.readString(Paths.get("src/test/resources/test.html")).trim();
        MockResponse mockResponse = new MockResponse()
                .setResponseCode(200)
                .setBody(body); //закинул в ожидаемый ответ код и тело
        mockWebServer.enqueue(mockResponse); //постатвил в очередь в ожидание сделанный ответ
        String testUrl = mockWebServer.url("/").toString(); //сделал фейк урл, преобразовал в строку

        JavalinTest.test(app, (server, client) -> {
            Url url  = new Url(testUrl);
            UrlRepository.save(url); //сохранил урлу в репо
            Long id = url.getId(); //взять айди у урлы
            client.post(NamedRoutes.checkPath(id)); //делать пост-запрос на проверку по указанной айди(которая ведёт к
            // фейк-мок серву с заготовленным ответом(данными) по нужным категориям
            var checkUrl = CheckRepository.find(Math.toIntExact(url.getId())).get(0); //взял из репо с проверками лист
            // с проверками, принадлежащими сущности по указанному айди
            assertThat(checkUrl.getTitle()).isEqualTo("GitHub: Let’s build from here · GitHub");
            assertThat(checkUrl.getH1()).isEqualTo("Search code, repositories, users, issues, pull requests...");
            assertThat(checkUrl.getDescription()).isEqualTo("Some description from GitHub, but small and fake");
        });
        mockWebServer.shutdown();
    }


}
