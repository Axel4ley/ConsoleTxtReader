Это описание того что сделано и как устроен проект.

1. Заполнить файл: jdbc.properties своими данными:
- FileStatistic/Console/**/resources/jdbc.properties
- FileStatistic/Web/**/resources/jdbc.properties

2. Создать базу - скрипт лежит в: /ConsoleTxtReader/src/test/resources/schema.sql.

3. Запустить консольное приложение: /ConsoleTxtReader/src/main/java/com/barkalov/consoleTxtReader/Application.java
при этом подставить свое значение в Application.java в DIRECTORY_URL
Результат: приложение вычитает статьи из предподготовленой директории /ConsoleTxtReader/data (и дочерних дерикторий) и запишет их в БД.

4 Юнит тесты написаны для приложения 'ConsoleTxtReader'. Используется встроеная в Spring база H2.

5. WEB APP:
Стартовая страница '/greeting'.


Что выполнено:
1 Implement console application(mandatory) (Done)
  +  Read txt file and split it by lines.
  +  Calculate statistic for each line: longest word(symbols between 2 spaces), shortest word, line length, average word length. Unit test are mandatory
  +  Aggregate these values for all lines from file(unit test)
  +  Store line and file statistic into DB(with JDBC).

2. Implement Web application (mandatory) (Done)
  + Create Hiberante mapping for tables
  + Return from server side list of handled files and statistic per file. You can use RESTful services or Spring MVC controllers
  + HTML+CSS+JS Implement frontend part - display list of files, and statistic per line for selected file. Usage of ReactJS framework is encouraged. In other case any other JS framework can be used

3. Add to console app possibility to handle all files in directory and sub-directories(optional)  (Done)

4. Add to Web app filter by file's statistic(example: files with more than 10 lines)(optional)  (Hasn't implemented)

5. Add to Web app possibility to enter and send own text for handling(optional) (Hasn't implemented)

6. Implement concurrent handling of each file in directory (Hasn't implemented)