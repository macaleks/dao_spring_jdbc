package ru.otus.jdbcprj;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import ru.otus.jdbcprj.dao.BookDao;
import ru.otus.jdbcprj.dao.BookDaoImpl;
import ru.otus.jdbcprj.model.Book;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JdbcTest
public class BookDaoImplTest {

    @Autowired
    private NamedParameterJdbcOperations operations;

    @Test
    public void test_getAll() {
        BookDao bookDao = new BookDaoImpl(operations);

        List<Book> books = bookDao.getAll();
        assertEquals(3, books.size());
    }

}
