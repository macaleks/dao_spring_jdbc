package ru.otus.jdbcprj.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.jdbcprj.model.Genre;

import java.util.HashMap;
import java.util.List;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class GenreDaoImpl implements GenreDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    private final RowMapper<Genre> mapper = (rs, i) -> {
        int id = rs.getInt("ID");
        String name = rs.getString("NAME");
        return new Genre(id, name);
    };

    public GenreDaoImpl(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public Genre getById(int id) {
        String sql = "select id, name from genres where id = :id";
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        return namedParameterJdbcOperations.queryForObject(sql, params, mapper);
    }

    @Override
    public List<Genre> getAll() {
        String sql = "select id, name from genres";
        return namedParameterJdbcOperations.query(sql, mapper);
    }

    @Override
    public int insert(Genre genre) {
        String sql = "insert into genre(id, name) values (:id, :name)";
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", genre.getId());
        params.put("name", genre.getName());
        return namedParameterJdbcOperations.update(sql, params);
    }

    @Override
    public int update(Genre genre) {
        String sql = "update genre set name = :name where id = :id";
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", genre.getId());
        params.put("name", genre.getName());
        return namedParameterJdbcOperations.update(sql, params);
    }

    @Override
    public int deleteById(int id) {
        String sql = "delete from genre where id = :id";
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        return namedParameterJdbcOperations.update(sql, params);
    }
}
