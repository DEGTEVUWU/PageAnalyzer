package gg.jte.generated.ondemand;
import gg.jte.Content;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,4,4,8,8,20,20,20,20,24,24,24};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <h1>Заголовок моего локал-сайта!</h1>\r\n    <h2>Подзаголовок! Если ты читаешь - пожалуйста, пользуйся</h2>\r\n\r\n    <h4>Тут ты увидишь:</h4>\r\n    <ul>\r\n        <li><a href=\"/\">Главную страницу</a></li>\r\n        <li><a href=\"/\">Список всех курсов(из прошлого курса)</a></li>\r\n        <li><a href=\"/\">Список всех сайтов</a></li>\r\n        <li>А вообще будем анализировать страницы других сайтов</li>\r\n\r\n    </ul>\r\n");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"footer\">\r\n        <a href=\"https://github.com/DEGTEVUWU\">Дёгтев Иван - профиль на GitHub</a>\r\n    </div>\r\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		render(jteOutput, jteHtmlInterceptor, content);
	}
}
