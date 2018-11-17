package ru.otus.spring.project.entity;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "book", schema = "spring_project_otus", catalog = "")
public class BookEntity {
    private long id;
    private String name;
    private byte[] content;
    private int pageCount;
    private String isbn;
    private int publishYear;
    private byte[] image;
    private String descr;
    private AuthorEntity authorByAuthorId;
    private long genreId;
    private long publisherId;

    public BookEntity() {
    }

    public BookEntity(long id, String name, byte[] content, int pageCount,
                      String isbn, int publishYear, byte[] image,
                      String descr, AuthorEntity authorByAuthorId, long genreId, long publisherId) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.image = image;
        this.descr = descr;
        this.authorByAuthorId = authorByAuthorId;
        this.genreId = genreId;
        this.publisherId = publisherId;
    }

    public BookEntity(long id, String name, int pageCount,
                      String isbn, int publishYear, String descr,
                      AuthorEntity authorByAuthorId, long genreId, long publisherId) {
        this(id, name, null, pageCount, isbn, publishYear, null, descr, authorByAuthorId, genreId, publisherId);
    }

    public BookEntity(long id, String name, int pageCount, String isbn, int publishYear, byte[] image, String descr, AuthorEntity authorByAuthorId, long genreId, long publisherId) {
        this(id, name, null, pageCount, isbn, publishYear, image, descr, authorByAuthorId, genreId, publisherId);
    }

    //    public BookEntity(Blob content) {
//        this(0, null, content, 0, null, 0, null, null, null);
//    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "content")
    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Basic
    @Column(name = "page_count")
    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Basic
    @Column(name = "isbn")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "publish_year")
    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "image")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Basic
    @Column(name = "descr")
    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    public AuthorEntity getAuthorByAuthorId() {
        return authorByAuthorId;
    }

    public void setAuthorByAuthorId(AuthorEntity authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }

    @Basic
    @Column(name = "genre_id")
    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public Long getGenreId() {
        return genreId;
    }

    @Basic
    @Column(name = "publisher_id")
    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return id == that.id &&
                pageCount == that.pageCount &&
                publishYear == that.publishYear &&
                Objects.equals(name, that.name) &&
                Arrays.equals(content, that.content) &&
                Objects.equals(isbn, that.isbn) &&
                Arrays.equals(image, that.image) &&
                Objects.equals(descr, that.descr);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, name, pageCount, isbn, publishYear, descr);
        result = 31 * result + Arrays.hashCode(content);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pageCount=" + pageCount +
                ", isbn='" + isbn + '\'' +
                ", publishYear=" + publishYear +
                ", descr='" + descr + '\'' +
                ", imageSize='" + image != null ? String.valueOf(image.length) : 0 + '\'' +
                ", content='" + content + '\'' +
                ", authorByAuthorId=" + authorByAuthorId +
                ", genreId=" + genreId +
                ", publisherId=" + publisherId +
                '}';
    }
}
