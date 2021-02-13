package ru.otus.jdbcprj.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.jdbcprj.model.Author;
import ru.otus.jdbcprj.model.Book;
import ru.otus.jdbcprj.model.Genre;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookDaoImpl implements BookDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    private final RowMapper<Book> mapper = (rs, i) -> {
        int idBook = rs.getInt("ID_BOOK");
        String bookName = rs.getString("BOOK_NAME");
        Integer idAuthor = rs.getInt("ID_AUTHOR");
        String firstName = rs.getString("FIRST_NAME");
        String secondName = rs.getString("SECOND_NAME");
        Integer idGenre = rs.getInt("ID_GENRE");
        String genreName = rs.getString("GENRE_NAME");
        Author author = new Author(idAuthor, firstName, secondName);
        Genre genre = new Genre(idGenre, genreName);
        return new Book(idBook, bookName, author, genre);
    };

    public BookDaoImpl(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public List<Book> getAll() {
        String sql = "select b.id as id_book, " +
                "            b.name as book_name, " +
                "            a.id as id_author, " +
                "            a.first_name, " +
                "            a.second_name," +
                "            g.id as id_genre," +
                "            g.name as genre_name " +
                "       from books b," +
                "            authors a," +
                "            genres g" +
                "      where b.id_author = a.id" +
                "        and b.id_genre = g.id";
        return namedParameterJdbcOperations.query(sql, mapper);
    }

    @Override
    public int insert(Book book) {
        String sql = "insert into books(id, name, id_author, id_genre) values (book_seq.nextval, :name, :id_author, :id_genre)";
        Map<String, Object> params = new HashMap<>();
        params.put("id", book.getId());
        params.put("name", book.getName());
        params.put("id_author", book.getAuthor().getId());
        params.put("id_genre", book.getGenre().getId());
        return namedParameterJdbcOperations.update(sql, params);
    }

    @Override
    public int update(Book book) {
        String sql = "update books set" +
                "                 name = :name, " +
                "                 id_author = :id_author, " +
                "                 id_genre = :id_genre" +
                "      where id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", book.getId());
        params.put("name", book.getName());
        params.put("id_author", book.getAuthor().getId());
        params.put("id_genre", book.getGenre().getId());
        return namedParameterJdbcOperations.update(sql, params);
    }

    @Override
    public int deleteById(int id) {
        String sql = "delete from books where id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return namedParameterJdbcOperations.update(sql, params);
    }
}
