package hexlet.code.utils;

import hexlet.code.model.Url;
import hexlet.code.repository.CheckRepository;

import java.sql.Timestamp;
import java.util.Optional;

public class InfoAboutCreateAndStatus {
    public static final Optional<Integer> getStatusCode(Url url)  {
        if (CheckRepository.findExisting(url.getId())) {
            var list = CheckRepository.find(Math.toIntExact(url.getId()));
            return Optional.of(list.get(list.size() - 1).getStatusCode());
        }
        return Optional.empty();
    }
    public static final Optional<Timestamp> getCheckCreatedAt(Url url) {
        if (CheckRepository.findExisting(url.getId())) {
            var list = CheckRepository.find(Math.toIntExact(url.getId()));
            if (!list.isEmpty()) {
                return Optional.of(list.get(list.size() - 1).getCreatedAt());
            }
        }
        return Optional.empty();
    }
}
