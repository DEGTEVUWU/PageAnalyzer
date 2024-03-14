package gg.jte.generated.ondemand.urls;
import hexlet.code.dto.UrlsPage;
import hexlet.code.utils.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "urls/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,6,6,11,11,14,14,14,16,16,18,18,21,21,24,24,24,27,27,27,27,27,27,27,27,27,27,27,27,27,27,30,30,32,32,37,37,37,37,43,43,43};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlsPage page) {
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"mx-auto p-4 py-md-5\">\r\n        <main>\r\n            <h2>");
				jteOutput.setContext("h2", null);
				jteOutput.writeUserContent("Это лист со всеми добавленными сайтами!");
				jteOutput.writeContent("</h2>\r\n            \r\n            ");
				if (page.getUrls().isEmpty()) {
					jteOutput.writeContent("\r\n                <p>Пока не добавлено ни одного сайта!</p>\r\n            ");
				} else {
					jteOutput.writeContent("\r\n\r\n                <table class=\"table table-striped\">\r\n                    ");
					for (var url : page.getUrls()) {
						jteOutput.writeContent("\r\n                        <tr>\r\n                            <td>\r\n                                ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(url.getId());
						jteOutput.writeContent("\r\n                            </td>\r\n                            <td>\r\n                                <a");
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(NamedRoutes.urlPath(url.getId()))) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(NamedRoutes.urlPath(url.getId()));
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(url.getName());
						jteOutput.writeContent(" ");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(String.valueOf(url.getCreatedAt()));
						jteOutput.writeContent("</a>\r\n                            </td>\r\n                        </tr>\r\n                    ");
					}
					jteOutput.writeContent("\r\n                </table>\r\n            ");
				}
				jteOutput.writeContent("\r\n\r\n\r\n        </main>\r\n    </div>\r\n");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"footer\">\r\n        <a>Спасибо, что посетили мой сайт! И в особенности эту страницу со всеми юзерами! Жду снова!</a>\r\n        <br>\r\n        <a href=\"https://github.com/DEGTEVUWU\">Дёгтев Иван - профиль на GitHub</a>\r\n    </div>\r\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlsPage page = (UrlsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
