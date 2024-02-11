CREATE TABLE information_systems (
    id bigserial not null primary KEY,
    name varchar(100),
    rdbms_type varchar(10)
);

CREATE TABLE responsible_persons (
    id bigserial not null primary KEY,
    fio varchar(100),
    email varchar(100)
);

CREATE TABLE task_status (
    id bigserial not null primary KEY,
    description varchar(100)
);

CREATE TABLE credentials (
    id bigserial not null primary KEY,
    information_system_id bigint NOT NULL,
    login varchar(100) NOT NULL,
    description varchar(1000) NOT NULL,
    responsible_person_id bigint NOT NULL,
    task_status_id bigint NOT null default 1,
    foreign key (information_system_id) references information_systems (id),
    foreign key (responsible_person_id) references responsible_persons (id),
    foreign key (task_status_id) references task_status (id)
);

CREATE TABLE secrets (
    id bigserial not null primary KEY,
    credential_id bigint NOT NULL,
    secret varchar(1000) NOT NULL,
    foreign key (credential_id) references credentials (id)
);
create view detail_credentials as
select c.id,c.login ,c.description detail_credential_description, i_s.name information_systems_name,i_s.rdbms_type ,r_p.fio ,r_p.email ,t_s.description status_description,s.secret
from credentials c
join information_systems i_s on c.information_system_id = i_s.id
join responsible_persons r_p on c.responsible_person_id = r_p.id
join task_status t_s on c.task_status_id = t_s.id
left join secrets s on c.id = s.credential_id