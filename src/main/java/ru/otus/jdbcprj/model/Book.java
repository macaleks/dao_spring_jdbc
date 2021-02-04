package ru.otus.jdbcprj.model;

import java.util.List;

public class Book {
    private int id;
    private String name;
    private List<Integer> authorIds;
    private List<Integer> genreIds;

    public Book(int id, String name, List<Integer> authorIds, List<Integer> genreIds) {
        this.id = id;
        this.name = name;
        this.authorIds = authorIds;
        this.genreIds = genreIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getAuthorIds() {
        return authorIds;
    }

    public void setAuthorIds(List<Integer> authorIds) {
        this.authorIds = authorIds;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authorIds=" + authorIds +
                ", genreIds=" + genreIds +
                '}';
    }
}
