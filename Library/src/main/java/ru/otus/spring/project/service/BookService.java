package ru.otus.spring.project.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.spring.project.entity.BookEntity;
import ru.otus.spring.project.repository.BookRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @HystrixCommand(commandKey = "findAllBooks", groupKey = "BookService")
    public List<BookEntity> getAllBook() {
        return bookRepository.findAll();
    }

    @HystrixCommand(commandKey = "findBookById", groupKey = "BookService")
    public BookEntity getBook(@PathVariable Long id) {
        return bookRepository.findById(id).get();
    }

    @HystrixCommand(commandKey = "findBookByGenre", groupKey = "BookService")
    public List<BookEntity> getAllBookByGenreId(Long genreId) {
        return bookRepository.findAllByGenreId(genreId);
    }

    @HystrixCommand(commandKey = "findAllBooksByName", groupKey = "BookService")
    public List<BookEntity> getAllBookByName(String name) {
        return bookRepository.findAllByName(name);
    }

    @HystrixCommand(commandKey = "deleteBookById", groupKey = "BookService")
    @Transactional(readOnly = false)
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @HystrixCommand(commandKey = "editBookById", groupKey = "BookService")
    @Transactional(readOnly = false)
    public void editBookById(BookEntity book) {
        bookRepository.save(book);
    }

//    public BookEntity getContentById(Long id) {
//        return bookRepository.findContentById(id);
//    }
}
