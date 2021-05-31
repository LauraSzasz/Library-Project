package com.library.Book.Library.service;

import com.library.Book.Library.entity.Author;
import com.library.Book.Library.entity.Book;
import com.library.Book.Library.enums.BookGenre;
import com.library.Book.Library.exception.ResourceNotFoundException;
import com.library.Book.Library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> findAll(){
        return bookRepository.findAllByOrderByTitleAsc();
    }

    public List<Book> findAllByTitleContaining(String title) {
        return bookRepository.findAllByTitleContaining(title);
    }

    public List<Book> findAllByAuthor(Author author) {
        return bookRepository.findAllByAuthor(author);
    }

    public List<Book> findAllByGenre(BookGenre genre) {
        return bookRepository.findAllByGenre(genre);
    }

    public List<Book> findAllByPublisher(String publisher) {
        return bookRepository.findAllByPublisher(publisher);
    }

    public List<Book> findAllByReleaseDateAfter(Date releaseDate) {
        return bookRepository.findAllByReleaseDateAfter(releaseDate);
    }

    public void update(Long id, Book newBook) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            Book oldBook = book.get();
            oldBook.setTitle(newBook.getTitle());
            oldBook.setGenre(newBook.getGenre());
            oldBook.setIsbn(newBook.getIsbn());
            oldBook.setPagesNumber(newBook.getPagesNumber());
            oldBook.setNumberOfCopies(newBook.getNumberOfCopies());
            oldBook.setReleaseDate(newBook.getReleaseDate());
            oldBook.setPublisher(newBook.getPublisher());
            oldBook.setAvailable(newBook.isAvailable());
            oldBook.setAuthor(newBook.getAuthor());
        } else {
            throw new ResourceNotFoundException("Book was not found");
        }
    }

    public void delete(Book book) {
        bookRepository.delete(book);
    }

}
