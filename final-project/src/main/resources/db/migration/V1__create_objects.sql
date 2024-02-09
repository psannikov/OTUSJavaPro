CREATE TABLE information_systems (
    id bigserial not null primary KEY,
    name varchar(100),
    rdbms_type varchar(10),
    connection_string varchar(100)
);

CREATE TABLE responsible_persons (
    id bigserial not null primary KEY,
    fio varchar(100),
    email varchar(100)
);

CREATE TABLE status (
    id bigserial not null primary KEY,
    state varchar(100)
);

CREATE TABLE credentials (
    id bigserial not null primary KEY,
    information_system_id bigint NOT NULL,
    login varchar(100) NOT NULL,
    description varchar(1000) NOT NULL,
    responsible_person_id bigint NOT NULL,
    state_id bigint NOT null default 1,
    foreign key (information_system_id) references information_systems (id),
    foreign key (responsible_person_id) references responsible_persons (id),
    foreign key (state_id) references status (id)
);

CREATE TABLE secrets (
    credential_id bigint NOT NULL,
    secret varchar(1000) NOT NULL,
    foreign key (credential_id) references credentials (id)
);