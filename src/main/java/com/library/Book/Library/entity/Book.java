package com.library.Book.Library.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.library.Book.Library.enums.BookGenre;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "books")
@NoArgsConstructor
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private BookGenre genre;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "pages_number")
    private Integer pagesNumber;

    @Column(name = "number_of_copies")
    private Integer numberOfCopies;

    @Column(name = "release_year")
    private Integer releaseYear;

    private String publisher;

    @Column(name = "is_available")
    private boolean isAvailable;

    @Column(name = "image_URL")
    private String imageURL;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @JsonManagedReference
    public Author getAuthor() {
        return author;
    }

    public Book(String title, BookGenre genre, String isbn, Integer pagesNumber, Integer numberOfCopies, Integer releaseDate, String publisher, boolean isAvailable, String imageURL, Author author) {
        this.title = title;
        this.genre = genre;
        this.isbn = isbn;
        this.pagesNumber = pagesNumber;
        this.numberOfCopies = numberOfCopies;
        this.releaseYear = releaseDate;
        this.publisher = publisher;
        this.isAvailable = isAvailable;
        this.imageURL = imageURL;
        this.author = author;
    }
}
