package ru.otus.jdbcprj.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.jdbcprj.model.Author;
import ru.otus.jdbcprj.model.Book;
import ru.otus.jdbcprj.model.Genre;
import ru.otus.jdbcprj.service.AuthorService;
import ru.otus.jdbcprj.service.BookService;
import ru.otus.jdbcprj.service.GenreService;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ShellComponent
public class ShellCommands {

    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;

    private Map<Integer, Genre> genres;
    private Map<Integer, Author> authors;
    private Map<Integer, Book> books;

    public ShellCommands(BookService bookService, AuthorService authorService, GenreService genreService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    @ShellMethod(value = "Get genres", key = {"g", "genre"})
    public String getGenres() {
        return Stream.concat(getHeader("id, name"),
                genres.values().stream()
                        .map(Genre::toString))
                .collect(Collectors.joining("\n"));
    }

    @ShellMethod(value = "Get authors", key = {"a", "author"})
    public String getAuthors() {
        return Stream.concat(getHeader("id, first_name, second_name"),
                authors.values().stream()
                        .map(Author::toString))
                .collect(Collectors.joining("\n"));
    }

    @ShellMethod(value = "Get books", key = {"b", "book"})
    public String getBooks() {
        extractBooks();
        return Stream.concat(getHeader("id, name, author, genre"),
                books.values().stream()
                        .map(Book::toString))
                .collect(Collectors.joining("\n"));
    }

    @ShellMethod(value = "Delete a book", key = {"d", "delete"})
    public void deleteBook(String id) {
        bookService.deleteById(Integer.valueOf(id));
        books.remove(id);
    }

    @ShellMethod(value = "Create a book", key = {"c", "create"})
    public void createBook(String bookName, String authorId, String genreId) {
        Book book = new Book(null, bookName, authors.get(Integer.valueOf(authorId)), genres.get(Integer.valueOf(genreId)));
        bookService.insert(book);
        extractBooks();
    }

    @ShellMethod(value = "Update a book", key = {"u", "update"})
    public Book updateBook(String id, String bookName, String authorId, String genreId) {
        Integer key = Integer.valueOf(id);
        Book book = new Book(key, bookName, authors.get(Integer.valueOf(authorId)), genres.get(Integer.valueOf(genreId)));
        bookService.update(book);
        books.put(key, book);
        return book;
    }

    @PostConstruct
    private void init() {
        authors = authorService.getAll().stream()
                .collect(Collectors.toMap(k -> k.getId(), Function.identity()));
        genres = genreService.getAll().stream()
                .collect(Collectors.toMap(k -> k.getId(), Function.identity()));
        books = new HashMap<>();
    }

    private Stream<String> getHeader(String header) {
        return Stream.of(header);
    }

    private void extractBooks() {
        books = bookService.getAll().stream()
                .collect(Collectors.toMap(k -> k.getId(), Function.identity()));
    }
}
