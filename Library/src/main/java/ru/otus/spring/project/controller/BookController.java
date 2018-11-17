package ru.otus.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.spring.project.entity.BookEntity;
import ru.otus.spring.project.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public @ResponseBody List<BookEntity> getAllBook() {
        return bookService.getAllBook();
    }

    @GetMapping("/{id}")
    public @ResponseBody BookEntity getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @GetMapping("/{genreId}/genreid")
    public @ResponseBody List<BookEntity> getAllBookByGenreId(@PathVariable Long genreId) {
        return bookService.getAllBookByGenreId(genreId);
    }

    @PostMapping
    public @ResponseBody List<BookEntity> getAllBookByName(@RequestBody String name) {
        List<BookEntity> result = bookService.getAllBookByName(name);
        return result;
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }

//    @GetMapping("/{id}/getcontent")
//    public @ResponseBody BookEntity getContent(@PathVariable Long id) {
//        return bookService.getContentById(id);
//    }
}
