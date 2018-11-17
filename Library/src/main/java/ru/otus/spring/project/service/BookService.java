package ru.otus.spring.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.spring.project.entity.BookEntity;
import ru.otus.spring.project.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookEntity> getAllBook() {
        return bookRepository.findAll();
    }

    public BookEntity getBook(@PathVariable Long id) {
        return bookRepository.findById(id).get();
    }

    public List<BookEntity> getAllBookByGenreId(Long genreId) {
        return bookRepository.findAllByGenreId(genreId);
    }

    public List<BookEntity> getAllBookByName(String name) {
        return bookRepository.findAllByName(name);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

//    public BookEntity getContentById(Long id) {
//        return bookRepository.findContentById(id);
//    }
}
