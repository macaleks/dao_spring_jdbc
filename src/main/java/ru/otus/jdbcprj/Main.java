package ru.otus.jdbcprj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.jdbcprj.dao.AuthorDao;
import ru.otus.jdbcprj.model.Author;

@SpringBootApplication
public class Main {


    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = SpringApplication.run(Main.class);

        AuthorDao authorDao = context.getBean(AuthorDao.class);

        Author author = authorDao.getById(1);

        System.out.println(author);

        authorDao.getAll().stream().forEach(System.out::println);
    }

}
