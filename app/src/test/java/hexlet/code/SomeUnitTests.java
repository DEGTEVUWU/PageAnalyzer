package hexlet.code;

import hexlet.code.dto.BuildUrlPage;
import hexlet.code.dto.UrlPage;
import hexlet.code.dto.UrlsPage;
import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;
import hexlet.code.utils.FormattedTime;
import io.javalin.validation.ValidationError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SomeUnitTests {
    static Timestamp currentTime = FormattedTime.currentTime();
    private Url url1;
    private Url url2;
    private UrlCheck urlCheck1;
    @BeforeEach
    public final void setUp() throws IOException, SQLException {
        url1 = new Url("https://www.youtube.com");
        url1.setCreatedAt(currentTime);
        url1.setId(1L);
        url2 = new Url("https://www.youtube111.com");
        url2.setCreatedAt(currentTime);
        url2.setId(2L);
        urlCheck1 = new UrlCheck(200, "title", "h1", "description", 1L, currentTime);
        urlCheck1.setId(1L);

    }
    @Test
    public void testBuildUrlPage() {
        Map<String, List<ValidationError<Object>>> testMap = new HashMap<String, List<ValidationError<Object>>>();
        List<ValidationError<Object>> testList = new ArrayList<>();
        var validationError = new ValidationError<Object>("Error!!!");
        testList.add(validationError);
        testMap.put("error", testList);
        var actual = new BuildUrlPage("https://www.youtube.com", testMap);
        actual.setFlash("flash");
        actual.setFlashType("success");

        String expectedName = "https://www.youtube.com";
        ValidationError<Object> expectedError = new ValidationError("Error!!!");


        assertThat(actual.getName()).isEqualTo(expectedName);
        assertThat(actual.getErrors().get("error").get(0)).isEqualTo(expectedError);
        //получить из BuildUrlPage мапу с ошибками,
        // взять по стр-ключу лист, взять первый объект
        assertThat(actual.getFlash()).isEqualTo("flash");
        assertThat(actual.getFlashType()).isEqualTo("success");
    }
    @Test
    public void testUrlsPage() {
        UrlsPage actual = new UrlsPage();
        List<Url> list = new ArrayList<>();
        list.add(url1);
        list.add(url2);

        actual.setUrls(list);
        actual.setFlash("flash");
        actual.setFlashType("success");

        assertThat(actual.getUrls().get(0).getName()).isEqualTo("https://www.youtube.com");
        assertThat(actual.getUrls().get(1).getName()).isEqualTo("https://www.youtube111.com");
        assertThat(actual.getFlash()).isEqualTo("flash");
        assertThat(actual.getFlashType()).isEqualTo("success");
    }

    @Test
    public void testUrlPage() {
        UrlPage actual = new UrlPage();
        List<UrlCheck> urlCheckList = new ArrayList<>();

        urlCheckList.add(urlCheck1);

        actual.setUrl(url1); //закинули в тестовую UrlPage - сам урл, оба флеша и лист с объектом урл-чек
        actual.setFlash("flash");
        actual.setFlashType("success");
        actual.setUrlChecks(urlCheckList);

        assertThat(actual.getUrl().getName()).isEqualTo("https://www.youtube.com");
        assertThat(actual.getUrlChecks().get(0).getId()).isEqualTo(1);
        assertThat(actual.getUrlChecks().get(0).getStatusCode()).isEqualTo(200);
        assertThat(actual.getUrlChecks().get(0).getTitle()).isEqualTo("title");
        assertThat(actual.getUrlChecks().get(0).getH1()).isEqualTo("h1");
        assertThat(actual.getUrlChecks().get(0).getDescription()).isEqualTo("description");
        assertThat(actual.getUrlChecks().get(0).getUrlId()).isEqualTo(1);
        assertThat(actual.getUrlChecks().get(0).getCreatedAt()).isEqualTo(currentTime);

        assertThat(actual.getFlash()).isEqualTo("flash");
        assertThat(actual.getFlashType()).isEqualTo("success");
    }
}
