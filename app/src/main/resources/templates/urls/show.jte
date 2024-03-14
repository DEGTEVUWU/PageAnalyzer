@import hexlet.code.dto.UrlPage

@param UrlPage page

@template.layout.page(
content  = @`
    <main>
        <div class="mx-auto p-4 py-md-2">
            <h4>${page.getUrl().getId()}</h4>
        </div>

        <div class="mx-auto p-4 py-md-2">
            <h4>${page.getUrl().getName()}</h4>
        </div>
        <div class="mx-auto p-4 py-md-2">
            ${String.valueOf(page.getUrl().getCreatedAt())}
        </div>
    </main>
`
,
footer = @`
    <div class="footer">
        <a>Спасибо, что посетили мой сайт! Особенно эту страницу с полной информацией про сайт №
            ${page.getUrl().getId()} Жду снова!</a>
        <br>
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)