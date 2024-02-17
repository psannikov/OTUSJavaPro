INSERT INTO information_systems ("name", rdbms_type, url) VALUES
    ('Тестовый стенд Oracle','oracle','http://localhost:8190/worker/api/v1/password/change?login={0}&password={1}'),
    ('Тестовый стенд MySql','mysql',null),
    ('Тестовый стенд Postrges','postgres',null);
INSERT INTO responsible_persons (fio, email) values
    ('Иванов Иван Иванович', 'psannikov87@gmail.com'),
    ('Петров Петр Петрович', 'psannikov87@gmail.com'),
    ('Сидоров Сидр Сидорович', 'psannikov87@gmail.com');
INSERT INTO task_status (description) values
    ('Новая задача'),
    ('Работы запланированы'),
    ('Пароль сгенерирован'),
    ('Пароль передан'),
    ('Пароль обновлен'),
    ('Работы завершены');
insert into credentials (information_system_id,login,description,responsible_person_id) values
    (1, 'user_is_1', 'Первая внешняя система', 1),
    (1, 'user_is_2', 'Вторая внешняя система', 2),
    (2, 'user_is_3', 'Третья внешняя система', 3),
    (2, 'user_is_4', 'Четвертая внешняя система', 2),
    (2, 'user_is_5', 'Пятая внешняя система', 1),
    (3, 'user_is_6', 'Шестая внешняя система', 1);