package ru.otus.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.spring.project.entity.GenreEntity;
import ru.otus.spring.project.service.GenreService;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {

    private GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public @ResponseBody List<GenreEntity> findAll() {
        return genreService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody GenreEntity findById(@PathVariable Long id) {
        return genreService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        genreService.deleteById(id);
    }
}
