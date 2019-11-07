drop table if exists articles;

create table articles
(
    id     serial primary key,
    name   varchar(100) not null,
    text   text,
    date   varchar(100),
    writer varchar(100)
);

drop table if exists users;

create table users
(
    id                serial primary key,
    enabled           boolean,
    username          varchar(100) not null,
    encryptedPassword varchar(500) not null
);