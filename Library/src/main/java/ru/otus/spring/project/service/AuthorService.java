package ru.otus.spring.project.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.project.entity.AuthorEntity;
import ru.otus.spring.project.repository.AuthorRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @HystrixCommand(commandKey = "findAllAuthors", groupKey = "AuthorService")
    public List<AuthorEntity> findAll() {
        return authorRepository.findAll();
    }

    @HystrixCommand(commandKey = "findAuthorsById", groupKey = "AuthorService")
    public AuthorEntity findById(Long id) {
        return authorRepository.findById(id).get();
    }

    @HystrixCommand(commandKey = "deleteAuthorById", groupKey = "AuthorService")
    @Transactional(readOnly = false)
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
