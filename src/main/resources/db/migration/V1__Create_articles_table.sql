create table articles (
    id serial,
    name varchar(100) not null,
    text text,
    article_date date,
    writer varchar(100)
);