package ru.otus.spring.project.entity;

import javax.persistence.*;
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

    public BookEntity() {
    }

    public BookEntity(long id, String name, byte[] content, int pageCount,
                      String isbn, int publishYear, byte[] image,
                      String descr, AuthorEntity authorByAuthorId) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.image = image;
        this.descr = descr;
        this.authorByAuthorId = authorByAuthorId;
    }

    public BookEntity(long id, String name, int pageCount, String isbn, int publishYear, byte[] image, String descr, AuthorEntity authorByAuthorId) {
        this(id, name, null, pageCount, isbn, publishYear, image, descr, authorByAuthorId);
    }

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

    @Basic
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

    @Basic
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
                ", contentSize='" + content != null ? String.valueOf(content.length) : 0 + '\'' +
                ", authorByAuthorId=" + authorByAuthorId +
                '}';
    }
}
