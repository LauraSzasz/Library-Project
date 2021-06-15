package com.library.Book.Library.repository;
import com.library.Book.Library.entity.Author;
import com.library.Book.Library.entity.Book;
import com.library.Book.Library.enums.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByOrderByTitleAsc();

    Optional<Book> findByTitleAndAuthor (String title, Author author);

    List<Book> findAllByAuthor(Author author);

    List<Book> findAllByGenre(BookGenre genre);

    List<Book> findAllByNumberOfCopiesGreaterThan(Integer numberOfCopies);

    List<Book> findAllByPublisher(String publisher);

    List<Book> findAllByReleaseYearGreaterThan(Integer releaseYear);

    List<Book> findAllByTitleContaining(String title);

}
