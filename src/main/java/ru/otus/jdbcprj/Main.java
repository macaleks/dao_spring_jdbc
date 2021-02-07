package ru.otus.jdbcprj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.jdbcprj.dao.GenreDao;
import ru.otus.jdbcprj.model.Genre;

@SpringBootApplication
public class Main {


    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = SpringApplication.run(Main.class);

        GenreDao genreDao = context.getBean(GenreDao.class);

        Genre genre = genreDao.getById(1);

        System.out.println(genre);

//        genreDao.getAll().stream().forEach(System.out::println);
        genreDao.getAll().stream().forEach(System.out::println);
    }

}
