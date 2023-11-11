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
    number varchar(20)
);