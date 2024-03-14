package hexlet.code.utils;

public class NamedRoutes {
    public static String rootPath() {
        return "/";
    }
    //маршрут всех вывода всех урлов
    public static String urlsPath() {
        return "/urls";
    }

    //преобразование айди урла в строку
    public static String urlPath(Long id) {
        return urlPath(String.valueOf(id));
    }

    //маршрут для вывода конкретного урла
    public static String urlPath(String id) {
        return "/url/" + id;
    }

}
