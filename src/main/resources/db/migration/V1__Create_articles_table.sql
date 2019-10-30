create sequence article_id_seq;

create table articles (
    id int primary key default nextval('article_id_seq') ,
    name varchar(100) not null,
    text text,
    article_date date,
    writer varchar(100)
);

insert into articles (name, text, article_date, writer) values
                                                               ('Article 1', 'This is Article 1', '2019-10-28', 'Ante'),
                                                               ('Article 2', 'This is Article 2', '2019-10-29', 'Frame'),
                                                               ('Article 3', 'This is Article 3', '2019-10-30', 'Ivan'),
                                                               ('Article 4', 'This is Article 4', '2019-10-31', 'Vlaho'),
                                                               ('Article 5', 'This is Article 5', '2019-11-01', 'David');