package ru.otus.spring.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.otus.spring.project.entity.BookEntity;

import java.util.List;

public interface BookRepository extends CrudRepository<BookEntity, Long> {

    @Query("SELECT " +
            "new BookEntity(book.id, book.name, book.pageCount, book.isbn, book.publishYear, " +
            " book.image, book.descr, book.authorByAuthorId, book.genreId, book.publisherId)" +
            " FROM BookEntity book")
    List<BookEntity> findAll();

    @Query("SELECT " +
            "new BookEntity(book.id, book.name, book.pageCount, book.isbn, book.publishYear, " +
            " book.image, book.descr, book.authorByAuthorId, book.genreId, book.publisherId)" +
            " FROM BookEntity book" +
            " WHERE book.genreId = :genreId")
    List<BookEntity> findAllByGenreId(@Param("genreId") Long genreId);

    @Query("SELECT " +
            "new BookEntity(book.id, book.name, book.pageCount, book.isbn, book.publishYear, " +
            " book.image, book.descr, book.authorByAuthorId, book.genreId, book.publisherId)" +
            " FROM BookEntity book" +
            " WHERE book.name LIKE %:name%")
    List<BookEntity> findAllByName(@Param("name") String name);

    @Query("SELECT new BookEntity(book.id, book.name, book.content) FROM BookEntity book WHERE book.id = :id")
    BookEntity findContentById(@Param("id") Long id);
}
