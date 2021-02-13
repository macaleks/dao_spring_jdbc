package ru.otus.jdbcprj.service;

import ru.otus.jdbcprj.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAll();

    int insert(Book book);

    int update(Book book);

    int deleteById(int id);
}
