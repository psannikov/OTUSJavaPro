create sequence client_SEQ start with 1 increment by 1;

create table client
(
    id   bigint not null primary key,
    name varchar(50),
    addres_id bigint
);

create sequence addres_SEQ start with 1 increment by 1;

create table address
(
    id   bigint not null primary key,
    street varchar(100)
);

create sequence phone_SEQ start with 1 increment by 1;

create table phones
(
    id   bigint not null primary key,
    client_id bigint,
    number varchar(20)
);