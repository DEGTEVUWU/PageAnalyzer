package hexlet.code.dto;

import hexlet.code.BasePage;
import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BuildUrlPage extends BasePage {
    private String name;
//    private Timestamp created_at;
    private Map<String, List<ValidationError<Object>>> errors;

    public BuildUrlPage(Map<String, List<ValidationError<Object>>> errors) {
        this.errors = errors;
    }
}
