@import hexlet.code.dto.UrlsPage
@import hexlet.code.utils.NamedRoutes
@import hexlet.code.utils.FormattedTime
@param UrlsPage page


@template.layout.page(
page = page,
content  = @`
    <div class="mx-auto p-4 py-md-5">
        <main>

            <h2>${"Это лист со всеми добавленными сайтами!"}</h2>
            
            @if(page.getUrls().isEmpty())
                <p>Пока не добавлено ни одного сайта!</p>
            @else

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <td>
                            ID
                        </td>
                        <td>
                            Имя
                        </td>
                        <td>
                            Последняя проверка
                        </td>
                        <td>
                            Код ответа
                        </td>
                    </tr>
                    </thead>
                    @for(var url : page.getUrls())
                        <tbody>
                        <tr>
                            <td>
                                ${url.getId()}
                            </td>
                            <td>
                                <a href="${NamedRoutes.urlPath(url.getId())}">${url.getName()} </a>
                            </td>
                            <td>
                                @if(url.getCheckCreatedAt() != null)
                                    ${FormattedTime.formattedTime(url.getCreatedAt())}
                                    @endif
                            </td>
                            <td>
                                @if(url.getStatusCode() != null)
                                    ${url.getStatusCode()}
                                    @endif
                            </td>
                        </tr>
                        </tbody>
                    @endfor
                </table>
            @endif


        </main>
    </div>
`
,
footer = @`
    <div class="footer">
        <a>Спасибо, что посетили мой сайт! И в особенности эту страницу со всеми сайтами! Жду снова!</a>
        <br>
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)