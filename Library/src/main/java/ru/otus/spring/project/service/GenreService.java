package ru.otus.spring.project.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.project.entity.GenreEntity;
import ru.otus.spring.project.repository.GenreRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GenreService {

    private GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @HystrixCommand(commandKey = "findAllGenre", groupKey = "GenreService")
    public List<GenreEntity> findAll() {
        return genreRepository.findAll();
    }

    @HystrixCommand(commandKey = "findGenreById", groupKey = "GenreService")
    public GenreEntity findById(Long id) {
        return genreRepository.findById(id).get();
    }

    @HystrixCommand(commandKey = "deleteGenreById", groupKey = "GenreService")
    @Transactional(readOnly = false)
    public void deleteById(Long id) {
        genreRepository.deleteById(id);
    }
}
