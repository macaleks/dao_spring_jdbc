package ru.otus.jdbcprj.dao;

import org.springframework.stereotype.Repository;
import ru.otus.jdbcprj.model.Author;

import java.util.List;

public interface AuthorDao {

    Author getById(int id);
    List<Author> getAll();
    int insert(Author author);
    int update(Author author);
    int deleteById(int id);
}
