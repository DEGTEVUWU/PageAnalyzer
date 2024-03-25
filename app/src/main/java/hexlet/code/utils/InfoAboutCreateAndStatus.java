package hexlet.code.utils;

import hexlet.code.model.Url;
import hexlet.code.repository.CheckRepository;

import java.sql.Timestamp;

public class InfoAboutCreateAndStatus {
    public static final Integer getStatusCode(Url url)  {
        if (CheckRepository.findExisting(url.getId())) {
            var list = CheckRepository.find(Math.toIntExact(url.getId()));
            return list.get(list.size() - 1).getStatusCode();
        }
        return  null;
    }
    public static final Timestamp getCheckCreatedAt(Url url) {
        if (CheckRepository.findExisting(url.getId())) {
            var list = CheckRepository.find(Math.toIntExact(url.getId()));
            return list.get(list.size() - 1).getCreatedAt();
        }
        return null;
    }
}
