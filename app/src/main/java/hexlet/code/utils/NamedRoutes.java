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
        return "/urls/" + id;
    }


    //маршрут для пост-запроса по проверке сайта(урла)
    public static String checkPath(Long id) {
        return checkPath(String.valueOf(id));
    }

    //маршрут для пост-запроса по проверке сайта(урла)
    public static String checkPath(String id) {
        return "/urls/" + id + "/checks";
    }

}
