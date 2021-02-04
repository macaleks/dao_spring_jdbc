package ru.otus.jdbcprj.dao;

import ru.otus.jdbcprj.model.Genre;

import java.util.List;

public interface GenreDao {

    Genre getById(int id);
    List<Genre> getAll();
    int insert(Genre genre);
    int update(Genre genre);
    int deleteById(int id);
}
