--
create table books(id number primary key, name varchar2(255 char) not null);

create table genres(id number primary key, name varchar2(255 char) not null);

create table authors(id number primary key, first_name varchar2(255 char) not null, second_name varchar2(255 char) not null);

create table author_map(id_book number not null references books(id),
                        id_author number not null references authors(id),
                        constraint author_map primary key (id_book, id_author));

create table genre_map(id_book number not null references books(id),
                       id_genre number not null references genres(id),
                       constraint genre_map_pk primary key (id_book, id_genre));
