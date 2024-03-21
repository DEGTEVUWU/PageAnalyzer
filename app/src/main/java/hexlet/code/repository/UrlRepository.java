package hexlet.code.repository;

import hexlet.code.model.Url;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static hexlet.code.repository.BaseRepository.dataSource;


public class UrlRepository extends BaseRepository {

    public static void save(Url url) throws SQLException {
        String sql = "INSERT INTO urls (name, created_at) VALUES (?, ?)";
        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            Date actualDate = new Date();
            Timestamp createdAt = new Timestamp(actualDate.getTime());

            preparedStatement.setString(1, url.getName());
            preparedStatement.setTimestamp(2, createdAt);
            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            // Устанавливаем ID в сохраненную сущность
            if (generatedKeys.next()) {
                url.setId(generatedKeys.getLong(1));
                url.setCreatedAt(createdAt);
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }
//public static void save(Url url) throws SQLException {
//    var sql = "INSERT INTO urls(name, created_at) VALUES (?,?)";
//    try (var conn = dataSource.getConnection();
//         var stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//        stmt.setString(1, url.getName());
//        var date = new Date();
//        var createdAt = new Timestamp(date.getTime());
//        stmt.setTimestamp(2, createdAt);
//        stmt.executeUpdate();
//        var generatedKeys = stmt.getGeneratedKeys();
//        if (generatedKeys.next()) {
//            url.setId(generatedKeys.getLong(1));
//            url.setCreatedAt(createdAt);
//        } else {
//            throw new SQLException("DB have not returned ID after saving an entity");
//        }
//    }
//}


    public static Optional<Url> find(Long id) throws SQLException {
        var sql = "SELECT * FROM urls WHERE id = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var name = resultSet.getString("name");
//                Timestamp created_at = Timestamp.valueOf(resultSet.getString("created_at"));
                Url url = new Url(name);
                url.setId(id);
                url.setCreatedAt(resultSet.getTimestamp("created_at"));
                return Optional.of(url);
            }
            return Optional.empty();
        }
    }
    public static boolean findExisting(String name) throws SQLException {
        var sql = "SELECT * FROM urls WHERE name = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            var resultSet = stmt.executeQuery();
            return resultSet.next();
        }
    }

    public static List<Url> getEntities() throws SQLException {
        var sql = "SELECT * FROM urls";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            var resultSet = stmt.executeQuery();
            var result = new ArrayList<Url>();
            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var name = resultSet.getString("name");
                Url url = new Url(name);
                url.setId(id);
                url.setCreatedAt(resultSet.getTimestamp("created_at"));
                result.add(url);
            }
            return result;
        }
    }

}
