# Анализатор страниц #

### Hexlet tests and linter status:
[![Actions Status](https://github.com/DEGTEVUWU/java-project-72/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/DEGTEVUWU/java-project-72/actions)
[![Basic Functionality Check](https://github.com/DEGTEVUWU/java-project-72/actions/workflows/main.yml/badge.svg)](https://github.com/DEGTEVUWU/java-project-72/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/f89f050e2227bbdae348/maintainability)](https://codeclimate.com/github/DEGTEVUWU/java-project-72/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/f89f050e2227bbdae348/test_coverage)](https://codeclimate.com/github/DEGTEVUWU/java-project-72/test_coverage)

## Описание ##

Анализатор страниц - веб-сайт, основанный на платформе Javelin. Здесь отрабатываются основные принципы построения современных сайтов на архитектуре MVC: работа с маршрутизацией, обработчиками запросов и шаблонизатором, взаимодействие с базой данных через ORM. ОСновная задача - делать анализ других сайтов на SEO-пригодность. 

### Реализовано ###

Проверяем, что страница добавляется впервые. Проверка того, что введенная ссылка является сайтом (с протоколом, доменом) На каждом добавленном сайте отображается дата последней проверки и код ответа. Для каждого добавленного сайта вы можете запустить проверку доступности сайта и посмотреть его заголовки и описание.

#### Необходимо для локального подключения: ####  
- [Git installed](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)  
- [Java](https://www.oracle.com/java/technologies/downloads)  
- [Gradle](https://gradle.org/install)

### Подключи и используй локально ###

```
git clone git@github.com:DEGTEVUWU/java-project-72.git
cd java-project-72
make run
```

### Использованые технологии ###
- Фреймворк: Javelin
- Веб: Bootstrap
- Парсер: Jsoup
- Тесты: JUnit 5, Unirest, Mockwebserver
- Отчет о тестах: Jacoco
- Линтер: Checkstyle
- Базы данных: H2 (внутренняя), PostgreSQL (в продакшн)
- [Задеплоено](https://java-project-72-est1.onrender.com/) на бесплатный сервер от Render

### Пример работы ###
![image](https://github.com/DEGTEVUWU/java-project-72/assets/148809450/ac3657bf-a441-473b-81fd-f37b8058c1e2)
![image](https://github.com/DEGTEVUWU/java-project-72/assets/148809450/3078872c-1075-4f22-a955-91435e97c018)
![image](https://github.com/DEGTEVUWU/java-project-72/assets/148809450/716ae9ae-1a2b-4e0c-81db-6b21bc671e1d)

