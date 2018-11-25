package ru.otus.spring.project.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @HystrixCommand(commandKey = "findAllBooks", groupKey = "BookService")
    public List<BookEntity> getAllBook() {
        return bookRepository.findAll();
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @HystrixCommand(commandKey = "findBookById", groupKey = "BookService")
    public BookEntity getBook(@PathVariable Long id) {
        return bookRepository.findById(id).get();
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @HystrixCommand(commandKey = "findBookByGenre", groupKey = "BookService")
    public List<BookEntity> getAllBookByGenreId(Long genreId) {
        return bookRepository.findAllByGenreId(genreId);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @HystrixCommand(commandKey = "findAllBooksByName", groupKey = "BookService")
    public List<BookEntity> getAllBookByName(String name) {
        return bookRepository.findAllByName(name);
    }

    @Secured({"ROLE_ADMIN"})
    @HystrixCommand(commandKey = "deleteBookById", groupKey = "BookService")
    @Transactional(readOnly = false)
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Secured({"ROLE_ADMIN"})
    @HystrixCommand(commandKey = "editBookById", groupKey = "BookService")
    @Transactional(readOnly = false)
    public void editBookById(BookEntity book) {
        BookEntity bookTmp = bookRepository.findById(book.getId()).get();
        bookTmp.setAuthorByAuthorId(book.getAuthorByAuthorId());
        bookTmp.setDescr(book.getDescr());
        bookTmp.setGenreId(book.getGenreId());
        bookTmp.setIsbn(book.getIsbn());
        bookTmp.setName(book.getName());
        bookTmp.setPageCount(book.getPageCount());
        bookTmp.setPublisherId(book.getPublisherId());
        bookTmp.setPublishYear(book.getPublishYear());
        bookRepository.save(bookTmp);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @HystrixCommand(commandKey = "findContentBookById", groupKey = "BookService")
    public BookEntity findContentById(Long id) {
        return bookRepository.findContentById(id);
    }
}
