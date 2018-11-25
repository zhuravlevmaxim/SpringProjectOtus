package ru.otus.spring.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import ru.otus.spring.project.entity.AuthorEntity;
import ru.otus.spring.project.entity.BookEntity;
import ru.otus.spring.project.repository.AuthorRepository;
import ru.otus.spring.project.repository.BookRepository;

import java.util.List;


@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
