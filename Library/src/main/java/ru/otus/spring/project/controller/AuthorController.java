package ru.otus.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.spring.project.entity.AuthorEntity;
import ru.otus.spring.project.service.AuthorService;

import java.util.List;

@RestController("/author")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public @ResponseBody List<AuthorEntity> findAll() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody AuthorEntity findById(@PathVariable Long id) {
        return authorService.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id) {
        authorService.deleteById(id);
    }
}
