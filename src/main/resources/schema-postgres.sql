drop table if exists articles;

create table articles (
                          id serial primary key,
                          name varchar(100) not null,
                          text text,
                          article_date varchar(100),
                          writer varchar(100)
);