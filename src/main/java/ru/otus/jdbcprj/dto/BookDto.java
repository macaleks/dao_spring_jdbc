package ru.otus.jdbcprj.dto;

import ru.otus.jdbcprj.model.Author;
import ru.otus.jdbcprj.model.Genre;

import java.util.List;

public class BookDto {
    private int id;
    private String name;
    private List<Author> authors;
    private List<Genre> genres;

    public BookDto(int id, String name, List<Author> authors, List<Genre> genres) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.genres = genres;
    }

    public BookDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authors=" + authors +
                ", genres=" + genres +
                '}';
    }
}
