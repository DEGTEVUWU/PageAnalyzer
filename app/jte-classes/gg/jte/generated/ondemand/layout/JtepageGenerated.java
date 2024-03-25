package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
import hexlet.code.dto.BasePage;
import hexlet.code.utils.NamedRoutes;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,24,24,24,24,24,24,24,24,24,25,25,25,25,25,25,25,25,33,33,34,34,34,34,35,35,35,37,37,39,39,39,44,44,44,47};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, Content footer, BasePage page) {
		jteOutput.writeContent("\r\n<!doctype html>\r\n<html>\r\n<head>\r\n    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n    <title>Анализатор страниц</title>\r\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">\r\n    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\" crossorigin=\"anonymous\"></script>\r\n</head>\r\n\r\n<body class=\"d-flex flex-column min-vh-100\">\r\n<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n        <div class=\"container-fluid\">\r\n            <a class=\"navbar-brand\" href=\"/\">Анализатор страниц</a>\r\n            <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\r\n                <div class=\"navbar-nav\">\r\n                    <a class=\"nav-link\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(NamedRoutes.rootPath())) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(NamedRoutes.rootPath());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Главная</a>\r\n                    <a class=\"nav-link\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(NamedRoutes.urlsPath())) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(NamedRoutes.urlsPath());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Сайты</a>\r\n                </div>\r\n            </div>\r\n        </div>\r\n</nav>\r\n</body>\r\n<main>\r\n\r\n    ");
		if (page != null && page.getFlash() != null) {
			jteOutput.writeContent("\r\n        <div class=\"alert alert-");
			jteOutput.setContext("div", "class");
			jteOutput.writeUserContent(page.getFlashType());
			jteOutput.setContext("div", null);
			jteOutput.writeContent("\" role=\"alert\">\r\n            ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(page.getFlash());
			jteOutput.writeContent("\r\n        </div>\r\n    ");
		}
		jteOutput.writeContent("\r\n\r\n    ");
		jteOutput.setContext("main", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\r\n\r\n</main>\r\n<footer class=\"text-center text-lg-start bg-light text-muted\">\r\n    <div class=\"text-center p-4\" style=\"background-color: rgba(0, 0, 0, 0.05);\">\r\n        ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(footer);
		jteOutput.writeContent("\r\n    </div>\r\n</footer>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.getOrDefault("content", null);
		Content footer = (Content)params.getOrDefault("footer", null);
		BasePage page = (BasePage)params.getOrDefault("page", null);
		render(jteOutput, jteHtmlInterceptor, content, footer, page);
	}
}
