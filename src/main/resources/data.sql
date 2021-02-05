--
insert into books(id, name) values (1, 'Good Omens');
insert into books(id, name) values (2, 'Heads You Lose');
insert into books(id, name) values (3, 'Between the Lines');

insert into authors(id, first_name, second_name) values (1, 'Neil', 'Gaiman');
insert into authors(id, first_name, second_name) values (2, 'Terry' ,'Pratchett');
insert into authors(id, first_name, second_name) values (3, 'Lisa', 'Lutz');
insert into authors(id, first_name, second_name) values (4, 'David', 'Hayward');
insert into authors(id, first_name, second_name) values (5, 'Jodi', 'Picoult');
insert into authors(id, first_name, second_name) values (6, 'Samantha', 'Leer');


insert into genres(id, name) values (1, 'biography');
insert into genres(id, name) values (2, 'fable');
insert into genres(id, name) values (3, 'realistic');
insert into genres(id, name) values (4, 'fiction');
insert into genres(id, name) values (5, 'poetry');
insert into genres(id, name) values (6, 'science fiction');
insert into genres(id, name) values (7, 'drama');
insert into genres(id, name) values (8, 'fantasy');
insert into genres(id, name) values (9, 'mystery');


insert into author_map(id_book, id_author) values (1, 1);
insert into author_map(id_book, id_author) values (1, 2);
insert into author_map(id_book, id_author) values (2, 3);
insert into author_map(id_book, id_author) values (2, 4);
insert into author_map(id_book, id_author) values (3, 5);
insert into author_map(id_book, id_author) values (3, 6);


insert into genre_map(id_book, id_genre) values(1, 1);
insert into genre_map(id_book, id_genre) values(2, 7);
insert into genre_map(id_book, id_genre) values(3, 8);
insert into genre_map(id_book, id_genre) values(3, 6);