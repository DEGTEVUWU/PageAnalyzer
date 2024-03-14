@import gg.jte.Content
@import hexlet.code.dto.BuildUrlPage
@import hexlet.code.utils.NamedRoutes

@param Content content
@param BuildUrlPage page

@template.layout.page(
content  = @`
    <h2>Проверка сайтов на SEO-пригодность</h2>

    <h4>Тут ты увидишь:</h4>
    <ul>
        <li><a href="/">Главную страницу</a></li>
        <li><a href="${NamedRoutes.urlsPath()}">Список всех добавленных сайтов</a></li>
        <li>Инфу про каждый конкретный сайт</li>
        <li>А вообще будем анализировать страницы других сайтов</li>

    </ul>

    <form action="${NamedRoutes.urlsPath()}" method="post">
        <div class="mb-3">
            <label class="form-label">
                Адрес
                <input type="text" class="form-control" name="url"/>
            </label>
        </div>
        <input type="submit" value="Проверить" />
    </form>
    
`
,
footer = @`
    <div class="footer">
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)