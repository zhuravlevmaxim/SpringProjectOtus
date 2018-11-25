package ru.otus.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.spring.project.entity.BookEntity;
import ru.otus.spring.project.service.BookService;

import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
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

    @PostMapping("/editbook")
    public void editBook(@RequestBody BookEntity book) {
        bookService.editBookById(book);
    }

    @GetMapping("/{id}/getcontent")
    public BookEntity findContentById(@PathVariable Long id, HttpServletResponse response) {
//        BookEntity book =
        return bookService.findContentById(id);
//        byte[] content = book.getContent();
//        try {
//            response.setHeader("Content-Disposition", "inline; filename=\"" + book.getName() + ".pdf\"");
//            response.setDateHeader("Expires", -1);
//            response.setContentType("application/pdf");
//            response.setContentLength(content.length);
//            response.getOutputStream().write(content);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ResponseEntity.ok("ok");
    }
}
