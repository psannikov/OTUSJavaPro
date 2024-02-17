create table information_systems (id bigserial not null primary key, name varchar(100), rdbms_type varchar(10), url varchar(1000));

create table responsible_persons (id bigserial not null primary key, fio varchar(100), email varchar(100));

create table task_status (id bigserial not null primary key, description varchar(100));

create table credentials (id bigserial not null primary key, information_system_id bigint not null, login varchar(100) not null,
    description varchar(1000) not null, responsible_person_id bigint not null, task_status_id bigint not null default 1,
    foreign key (information_system_id) references information_systems (id), foreign key (responsible_person_id) references responsible_persons (id),
    foreign key (task_status_id) references task_status (id));

create table secrets (id bigserial not null primary key, credential_id bigint not null, secret varchar(1000) not null,
    foreign key (credential_id) references credentials (id));

alter table public.secrets add constraint secrets_unique unique (credential_id);

create table information_system_symbol_exclude (information_system varchar(1000), symbol varchar(1));

create or replace function pwd_gen(len int, var_infromation_system varchar) returns varchar as $$
declare
   available_chars varchar := '';
   generated_pwd varchar := '';

excluded_symbols cursor for
select symbol
from information_system_symbol_exclude
where information_system = var_infromation_system;

excluded_symbol varchar;

begin
-- формируем строку с доступными символами для пароля
available_chars := '0123456789abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz~!@#$%^&*()-=_+[]{}|;:,.<>?';
-- исключаем символы, указанные в таблице information_system_symbol_exclude
    for excluded_symbol in excluded_symbols loop
        available_chars := replace(available_chars,excluded_symbol,'');
end loop;
-- генерируем случайный пароль
    select string_agg(substring(available_chars, (random() * length(available_chars) + 1)::int, 1), '')
    into generated_pwd
    from generate_series(1, len);

return generated_pwd;
end;
$$ language plpgsql;

create view detail_credentials as
select
	c.id,
	c.login ,
	c.description detail_credential_description,
	i_s.name information_systems_name,
	i_s.rdbms_type ,
	r_p.fio ,
	r_p.email ,
	t_s.description status_description,
	s.secret
from credentials c
join information_systems i_s on c.information_system_id = i_s.id
join responsible_persons r_p on	c.responsible_person_id = r_p.id
join task_status t_s on c.task_status_id = t_s.id
left join secrets s on c.id = s.credential_id;
