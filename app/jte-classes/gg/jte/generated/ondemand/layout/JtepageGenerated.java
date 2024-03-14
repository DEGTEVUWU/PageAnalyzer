package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,38,38,38,38,43,43,43,47};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, Content footer) {
		jteOutput.writeContent("\r\n<html lang=\"en\">\r\n<head>\r\n    <meta charset=\"utf-8\" />\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"\r\n          rel=\"stylesheet\"\r\n          integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"\r\n          crossorigin=\"anonymous\">\r\n    <title>Hello Hexlet!</title>\r\n</head>\r\n<body>\r\n<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"\r\n        integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\"\r\n        crossorigin=\"anonymous\"></script>\r\n\r\n<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n    <div class=\"collapse navbar-collapse\" id=\"navbarNavDropdown\">\r\n        <ul class=\"navbar-nav\">\r\n            <li class=\"nav-item active\">\r\n                <a class=\"nav-link\" href=\"/\">Главная</a>\r\n            </li>\r\n\r\n            <li class=\"nav-item\">\r\n                <a class=\"nav-link\" href=\"/\">Ещё одна ссыль в хедере</a>\r\n            </li>\r\n\r\n\r\n        </ul>\r\n    </div>\r\n</nav>\r\n\r\n<main>\r\n\r\n    ");
		jteOutput.setContext("main", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\r\n\r\n</main>\r\n<footer class=\"text-center text-lg-start bg-light text-muted\">\r\n    <div class=\"text-center p-4\" style=\"background-color: rgba(0, 0, 0, 0.05);\">\r\n        ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(footer);
		jteOutput.writeContent("\r\n    </div>\r\n</footer>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.getOrDefault("content", null);
		Content footer = (Content)params.getOrDefault("footer", null);
		render(jteOutput, jteHtmlInterceptor, content, footer);
	}
}
