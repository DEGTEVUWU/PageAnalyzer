package gg.jte.generated.ondemand.urls;
import hexlet.code.dto.UrlsPage;
import hexlet.code.model.UrlCheck;
import hexlet.code.utils.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "urls/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,7,7,12,12,15,16,17,18,19,20,21,21,21,23,23,25,25,44,44,48,48,48,51,51,51,51,51,51,51,51,51,51,51,54,54,55,55,55,56,56,59,59,60,60,60,61,61,65,65,67,67,72,72,72,72,78,78,78};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlsPage page) {
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"mx-auto p-4 py-md-5\">\r\n        <main>\r\n");
				jteOutput.writeContent("\r\n");
				jteOutput.writeContent("\r\n");
				jteOutput.writeContent("\r\n");
				jteOutput.writeContent("\r\n");
				jteOutput.writeContent("\r\n");
				jteOutput.writeContent("\r\n            <h2>");
				jteOutput.setContext("h2", null);
				jteOutput.writeUserContent("Это лист со всеми добавленными сайтами!");
				jteOutput.writeContent("</h2>\r\n            \r\n            ");
				if (page.getUrls().isEmpty()) {
					jteOutput.writeContent("\r\n                <p>Пока не добавлено ни одного сайта!</p>\r\n            ");
				} else {
					jteOutput.writeContent("\r\n\r\n                <table class=\"table table-striped\">\r\n                    <thead>\r\n                    <tr>\r\n                        <td>\r\n                            ID\r\n                        </td>\r\n                        <td>\r\n                            Имя\r\n                        </td>\r\n                        <td>\r\n                            Последняя проверка\r\n                        </td>\r\n                        <td>\r\n                            Код ответа\r\n                        </td>\r\n                    </tr>\r\n                    </thead>\r\n                    ");
					for (var url : page.getUrls()) {
						jteOutput.writeContent("\r\n                        <tbody>\r\n                        <tr>\r\n                            <td>\r\n                                ");
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
						jteOutput.writeContent(" </a>\r\n                            </td>\r\n                            <td>\r\n                                ");
						if (url.getCreatedAt() != null) {
							jteOutput.writeContent("\r\n                                ");
							jteOutput.setContext("td", null);
							jteOutput.writeUserContent(String.valueOf(url.getCreatedAt()));
							jteOutput.writeContent("\r\n                                    ");
						}
						jteOutput.writeContent("\r\n                            </td>\r\n                            <td>\r\n                                ");
						if (url.getStatusCode() != null) {
							jteOutput.writeContent("\r\n                                    ");
							jteOutput.setContext("td", null);
							jteOutput.writeUserContent(url.getStatusCode());
							jteOutput.writeContent("\r\n                                    ");
						}
						jteOutput.writeContent("\r\n                            </td>\r\n                        </tr>\r\n                        </tbody>\r\n                    ");
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
