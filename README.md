Реализованные пункты: 

1. Возможность создать короткую ссылку по полному URL.
2. По известной короткой ссылке осуществить перенаправление браузера пользователя на исходный URL.
3. Управление ссылками должно быть доступно только ограниченному кругу лиц.
4. Предусмотреть возможность удаления зарегистрированных коротких ссылок.
5. Предусмотреть возможность задания ограничение на срок “жизни” короткой ссылки.

Запуск программы:

1. установить [JDK 11](https://corretto.aws/downloads/latest/amazon-corretto-11-x64-windows-jdk.msi.) и [Maven](https://dlcdn.apache.org/maven/maven-3/3.8.4/binaries/apache-maven-3.8.4-bin.zip)
2. установить [MAMP](https://downloads.mamp.info/MAMP-PRO-WINDOWS/releases/5.0.4/MAMP_MAMP_PRO_5.0.4.exe)
3. открыть MAMP, запустить сервер с настройками по умолчанию
4. в MAMP нажать кнопку OpenWebStart page, в разделе MySQL перейти по ссылке phpMyAdmin
5. в phpMyAdmin создать новую базу данных
6. в папке проекта найти папку resources (src -> main -> resources), в файле application.properties ввести название БД
7. в командной строке зайти в папку UrlShortener
8. ввести команду "mvn clean spring-boot:run"
9. если порт 8080 занят, в папке проекта в файле "application.properties" изменить значение server.port на 8081
10. обращаться к сервису через Postman

Описание API:

Для доступа к действиям по пунктам 1 и 2 необходимо ввести в поле Authorization Username: user, Password: password
Для доступа к пункту 3 - Username: admin, Password: password

1. POST /short - генерирует короткую ссылку на основе ссылки, переданной в теле запроса
2. GET /{shortUrl} - совершает редирект по сгенерированной ранее короткой сссылке
3. DELETE/{shortUrl} - удаляет введенную в адресную строку ссылку
