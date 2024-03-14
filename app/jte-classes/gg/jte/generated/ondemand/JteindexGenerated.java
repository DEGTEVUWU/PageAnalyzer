package gg.jte.generated.ondemand;
import gg.jte.Content;
import hexlet.code.dto.BuildUrlPage;
import hexlet.code.utils.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,7,7,11,11,23,23,23,23,23,23,23,23,33,33,33,33,37,37,37};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, BuildUrlPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <h2>Проверка сайтов на SEO-пригодность</h2>\r\n\r\n    <h4>Тут ты увидишь:</h4>\r\n    <ul>\r\n        <li><a href=\"/\">Главную страницу</a></li>\r\n        <li><a href=\"/\">Список всех курсов(из прошлого курса)</a></li>\r\n        <li><a href=\"/\">Список всех сайтов</a></li>\r\n        <li>А вообще будем анализировать страницы других сайтов</li>\r\n\r\n    </ul>\r\n\r\n    <form");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(NamedRoutes.urlsPath())) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(NamedRoutes.urlsPath());
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\r\n        <div class=\"mb-3\">\r\n            <label class=\"form-label\">\r\n                Адрес\r\n                <input type=\"text\" class=\"form-control\" name=\"url\"/>\r\n            </label>\r\n        </div>\r\n        <input type=\"submit\" value=\"Проверить\" />\r\n    </form>\r\n    \r\n");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"footer\">\r\n        <a href=\"https://github.com/DEGTEVUWU\">Дёгтев Иван - профиль на GitHub</a>\r\n    </div>\r\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		BuildUrlPage page = (BuildUrlPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, content, page);
	}
}
