package ru.otus.spring.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.otus.spring.project.entity.BookEntity;

import java.util.List;

public interface BookRepository extends CrudRepository<BookEntity, Long> {

    @Query("SELECT " +
            "new BookEntity(book.id, book.name, book.pageCount, book.isbn, book.publishYear, book.image, book.descr, book.authorByAuthorId)" +
            " FROM BookEntity book")
    List<BookEntity> findAllWithOutContent();
}
