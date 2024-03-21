@import hexlet.code.dto.UrlPage
@import hexlet.code.utils.NamedRoutes

@param UrlPage page

@template.layout.page(
    page = page,
content  = @`
    <main>

        <h1>Сайт: ${page.getUrl().getName()}</h1>
        <table class="table table-bordered table-hover mt-3">
            <tr>
                <td>
                    ID
                </td>
                <td>
                    ${page.getUrl().getId()}
                </td>
            </tr>
            <tr>
                <td>
                    Имя
                </td>
                <td>
                    ${page.getUrl().getName()}
                </td>
            </tr>
            <tr>
                <td>
                    Дата создания
                </td>
                <td>
                    @if(page.getUrl().getCreatedAt() != null)
                    ${String.valueOf(page.getUrl().getCreatedAt())}
                        @endif
                </td>
            </tr>
        </table>
<br>
        <h2>Проверки</h2>

        <form action="${NamedRoutes.urlPath(page.getUrl().getId())}" method="post">
            <button type="submit" class="btn btn-primary">Проверить</button>
        </form>

        @if(page.getUrlChecks() != null)
        <table class="table table-bordered table-hover mt-3">
            <thead>
            <tr>
                <td>
                    ID
                </td>
                <td>
                    Код ответа
                </td>
                <td>
                    Title
                </td>
                <td>
                    H1
                </td>
                <td>
                    Description
                </td>
                <td>
                    Дата проверки
                </td>
            </tr>
            </thead>
            @for(var singlePage : page.getUrlChecks())
            <tbody>
            <tr>
                <td>
                    ${singlePage.getUrlId()}
                </td>
                <td>
                    ${singlePage.getStatusCode()}
                </td>
                <td>
                    ${singlePage.getTitle()}
                </td>
                <td>
                    ${singlePage.getH1()}
                </td>
                <td>
                    ${singlePage.getDescription()}
                </td>
                <td>
                    ${String.valueOf(singlePage.getCreatedAt())}
                </td>
            </tr>
            </tbody>
                @endfor
        </table>
        @endif
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