package ru.otus.jdbcprj.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import ru.otus.jdbcprj.model.Author;

import java.util.HashMap;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    private final RowMapper<Author> mapper = (rs, i) -> {
        int id = rs.getInt("ID");
        String firstName = rs.getString("FIRST_NAME");
        String secondName = rs.getString("SECOND_NAME");
        return new Author(id, firstName, secondName);
    };

    public AuthorDaoImpl(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public Author getById(int id) {
        String sql = "select id, first_name, second_name from authors where id = :id";
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        return namedParameterJdbcOperations.queryForObject(sql, params, mapper);
    }

    @Override
    public List<Author> getAll() {
        String sql = "select id, first_name, second_name from authors";
        return namedParameterJdbcOperations.query(sql, mapper);
    }

    @Override
    public int insert(Author author) {
        String sql = "insert into authors(id, first_name, second_name) values (:id, :first_name, :second_name)";
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", author.getId());
        params.put("first_name", author.getFirstName());
        params.put("second_name", author.getSecondName());
        return namedParameterJdbcOperations.update(sql, params);
    }

    @Override
    public int update(Author author) {
        String sql = "update authors set first_name = :first_name, second_name = :second_name where id = :id";
        HashMap<String, Object> params = new HashMap<>();
        params.put("first_name", author.getFirstName());
        params.put("second_name", author.getSecondName());
        return namedParameterJdbcOperations.update(sql, params);
    }

    @Override
    public int deleteById(int id) {
        String sql = "delete from authors where id = :id";
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        return namedParameterJdbcOperations.update(sql, params);
    }
}
