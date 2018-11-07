package ru.otus.spring.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.project.entity.AuthorEntity;
import ru.otus.spring.project.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorEntity> findAll() {
        return authorRepository.findAll();
    }

    public AuthorEntity findById(Long id) {
        return authorRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
