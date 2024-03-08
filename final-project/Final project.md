# Финальный проект OTUS Pro Java
Это финальный проект по курсу OTUS Java Pro Санникова П.В.
**Предметная область проекта -** в мое работе (занимаюсь эксплуатацией баз данных) есть рабочий процесс обновления паролей учетных записей для технологических учетных записей. Особенность таких учетных записей заключается в том, что под ними работает не конкертный пользователь, а какая-то другая внешная информационная система, последовательность работ по подготовке и проведению работ выглядит слеующим образом:
1. Связаться с владельцем учетной записи и договориться о сроках проведения работ (электронной почтой), отвественные лица могут меняться.
2. Подготовить новый пароль по определенным требованиям к паролям (длинна, используемые символы и прочее), в разных внешних системах требования могут отличаться.
3. Передать пароль отвественному лицу используя секретные средства передачи, есть отдальная информационная система для этого.
4. Обновить пароль в системе в зоне отвественности, баз данных в зонеотвественности достаточно большое колчиество, СУБД так же несколько.
5. Сообщить о смене паролей, обычно для оперативной связи в ходе работ используется Telegram.

Исходя из вышеописанного было подготовленно решение  реализующее каждый из этапов. Были использованы следующие зависимости в ходе реализации проекта:
* Spring boot jpa, web, thymeleaf, mail, telegrambots
* flywaydb
* postgresql
* ojdbc8
* lombok
## Конфигурация и запуск
Для запуска приложения необходим docker (запускается 2 образа баз данных postgres и 1 образ oracle). Для комфортной работы не менее 4Гб ОЗУ.

Все запуски docker образов описаны в ./docker/runConfigDB.src и ./docker/runTargetDB.src

После запуска целевых БД необходимо выполнить скриты создания необходимых объектов ./src/main/resources/db/migration/V0_prepare_target_db.sql, предпологается что в рабочем процессе этого делать не надо и необходимые объекты и права уже есть в целевых базах.

Все креденшелы вынесены в переменные окружения, которые необходимо инициализировать перед запуском приложения
* CONFIGURATION_DB_USERNAME - логин для подключения к конфигурационной БД
* CONFIGURATION_DB_PASSWORD - пароль для подключения к конфигурационной БД
* EMAIL_USERNAME - логин для подключения к почтовому серверу
* EMAIL_PASSWORD - пароль для подключения к почтовому серверу
* BOT_USERNAME - имя бота выполняющего отправку уведмолений
* BOT_TOKEN - токен бота выполняющего отправку уведмолений
* BOT_CHAT_ID - идентификатор канала в который будет отправлено уведомление

При необходимости можно сконфигурировать нужное количество целевых баз. Важно помнить что ключ переменной application.yml определяющий целевой коннект должен совпадать с именем ИС в справочниках конфигурационной базы.

spring.otherdatasource.**db1**.... = information_systems.**name**

В ходе запуска приложения в режиме деменстрации предлагается следующая последовательность запуска:
1. Запускается docker image для работы конфиграционной базы (Postgres) (./docker/runConfigDB.src)
2. Запускается docker image для работы целевой базы (Oracle) (./docker/runTargetDB.src)
3. Запускается docker image для работы целевой базы (Postgres) (./docker/runTargetDB.src)
4. Запускается приложение (./ru.otus.pro.psannikov.password.cahnger/MainApp)