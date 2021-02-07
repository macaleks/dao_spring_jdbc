package ru.otus.jdbcprj.dao;

import ru.otus.jdbcprj.model.Book;

import java.util.List;

public interface BookDao {

    List<Book> getAll();

    int insert(Book book);

    int update(Book book);

    int deleteById(int id);
}
