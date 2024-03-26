@import hexlet.code.dto.UrlsPage
@import hexlet.code.utils.InfoAboutCreateAndStatus
@import hexlet.code.utils.NamedRoutes
@import hexlet.code.utils.FormattedTime
@import java.sql.Timestamp
@import java.util.NoSuchElementException
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
                                @if(InfoAboutCreateAndStatus.getCheckCreatedAt(url).isPresent())
                                    ${FormattedTime.formattedTime(InfoAboutCreateAndStatus.getCheckCreatedAt(url).orElseThrow(()
                                     -> new NoSuchElementException("Created_at element not found!")))}
                                @endif

                            </td>
                            <td>
                                @if(InfoAboutCreateAndStatus.getStatusCode(url).isPresent())
                                    ${InfoAboutCreateAndStatus.getStatusCode(url).orElseThrow(()
                                         -> new NoSuchElementException("Status element not found!"))}
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