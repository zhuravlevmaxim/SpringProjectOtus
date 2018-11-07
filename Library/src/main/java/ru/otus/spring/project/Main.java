package ru.otus.spring.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.otus.spring.project.entity.AuthorEntity;
import ru.otus.spring.project.entity.BookEntity;
import ru.otus.spring.project.repository.AuthorRepository;
import ru.otus.spring.project.repository.BookRepository;

import java.util.List;


@SpringBootApplication
//@EnableCircuitBreaker
//@EnableHystrixDashboard
public class Main {
    public static void main(String[] args) {
        List<BookEntity> books = SpringApplication.run(Main.class, args).getBean(BookRepository.class).findAllWithOutContent();
        books.stream().forEach(book -> {
            System.out.println(book.getImage().length);
        });
    }
}