package ru.otus.jdbcprj.dao;

import ru.otus.jdbcprj.model.Book;

import java.util.List;

public interface BookDao {

    Book getById(int id);
    List<Book> getAll();
    void insert(Book book);
    void update(Book book);
    void deleteById(int id);
}
