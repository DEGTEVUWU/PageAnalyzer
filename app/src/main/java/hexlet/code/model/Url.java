package hexlet.code.model;

import hexlet.code.repository.CheckRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Url {
    private Long id;
    private String name;
    private Timestamp createdAt;
    public Url(String name) {
        this.name = name;
    }

    public Url(String name, Timestamp createdAt) {
        this.name = name;
        this.createdAt = createdAt;
    }
    public final Integer getStatusCode()  {
        if (CheckRepository.findExisting(this.id)) {
            var list = CheckRepository.find(Math.toIntExact(id));
            return list.get(list.size() - 1).getStatusCode();
        }
        return  null;
    }
    public final Timestamp getCheckCreatedAt() {
        if (CheckRepository.findExisting(this.id)) {
            var list = CheckRepository.find(Math.toIntExact(id));
            return list.get(list.size() - 1).getCreatedAt();
        }
        return null;
    }
}
