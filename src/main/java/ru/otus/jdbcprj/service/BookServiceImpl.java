package ru.otus.jdbcprj.service;

import org.springframework.stereotype.Service;
import ru.otus.jdbcprj.dao.BookDao;
import ru.otus.jdbcprj.model.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override
    public int insert(Book book) {
        return bookDao.insert(book);
    }

    @Override
    public int update(Book book) {
        return bookDao.update(book);
    }

    @Override
    public int deleteById(int id) {
        return bookDao.deleteById(id);
    }
}
