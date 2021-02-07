package ru.otus.jdbcprj.dao;

import ru.otus.jdbcprj.model.Author;

import java.util.List;

public interface AuthorDao {

    Author getById(int id);

    List<Author> getAll();
}
