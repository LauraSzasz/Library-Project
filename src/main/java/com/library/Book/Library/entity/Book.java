package com.library.Book.Library.entity;

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

    @Column(name = "release_date")
    private Date releaseDate;

    private String publisher;

    @Column(name = "is_available")
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(String title, BookGenre genre, String isbn, Integer pagesNumber, Integer numberOfCopies,
                Date releaseDate, String publisher, boolean isAvailable, Author author) {
        this.title = title;
        this.genre = genre;
        this.isbn = isbn;
        this.pagesNumber = pagesNumber;
        this.numberOfCopies = numberOfCopies;
        this.releaseDate = releaseDate;
        this.publisher = publisher;
        this.isAvailable = isAvailable;
        this.author = author;
    }
}
