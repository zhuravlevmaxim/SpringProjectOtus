package ru.otus.spring.project.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.project.entity.GenreEntity;
import ru.otus.spring.project.repository.GenreRepository;

import java.util.List;

@Service
public class GenreService {

    private GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<GenreEntity> findAll() {
        return genreRepository.findAll();
    }

    public GenreEntity findById(Long id) {
        return genreRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        genreRepository.deleteById(id);
    }
}
