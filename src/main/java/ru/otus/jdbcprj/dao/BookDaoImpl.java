package ru.otus.jdbcprj.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import ru.otus.jdbcprj.model.Book;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BookDaoImpl implements BookDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    private final RowMapper<Book> mapper = (rs, i) -> {
        int id = rs.getInt("ID");
        String name = rs.getString("NAME");
        List<Integer> authorIds = Arrays.asList(rs.getString("AUTHOR_IDS").split(","))
                .stream().map(Integer::valueOf).collect(toList());
        List<Integer> genreIds = Arrays.asList(rs.getString("GENRE_IDS").split(","))
                .stream().map(Integer::valueOf).collect(toList());
        return new Book(id, name, authorIds, genreIds);
    };

    public BookDaoImpl(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public Book getById(int id) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public void insert(Book book) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void deleteById(int id) {

    }
}
