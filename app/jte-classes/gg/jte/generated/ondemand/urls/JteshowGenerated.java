package gg.jte.generated.ondemand.urls;
import hexlet.code.dto.UrlPage;
public final class JteshowGenerated {
	public static final String JTE_NAME = "urls/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,4,4,8,8,11,11,11,15,15,15,18,18,18,21,21,21,21,24,24,24,28,28,28};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <main>\r\n        <div class=\"mx-auto p-4 py-md-2\">\r\n            <h4>");
				jteOutput.setContext("h4", null);
				jteOutput.writeUserContent(page.getUrl().getId());
				jteOutput.writeContent("</h4>\r\n        </div>\r\n\r\n        <div class=\"mx-auto p-4 py-md-2\">\r\n            <h4>");
				jteOutput.setContext("h4", null);
				jteOutput.writeUserContent(page.getUrl().getName());
				jteOutput.writeContent("</h4>\r\n        </div>\r\n        <div class=\"mx-auto p-4 py-md-2\">\r\n            ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(String.valueOf(page.getUrl().getCreatedAt()));
				jteOutput.writeContent("\r\n        </div>\r\n    </main>\r\n");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"footer\">\r\n        <a>Спасибо, что посетили мой сайт! Особенно эту страницу с полной информацией про сайт №\r\n            ");
				jteOutput.setContext("a", null);
				jteOutput.writeUserContent(page.getUrl().getId());
				jteOutput.writeContent(" Жду снова!</a>\r\n        <br>\r\n        <a href=\"https://github.com/DEGTEVUWU\">Дёгтев Иван - профиль на GitHub</a>\r\n    </div>\r\n");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlPage page = (UrlPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
