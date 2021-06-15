package com.library.Book.Library.controller;

import com.library.Book.Library.entity.Author;
import com.library.Book.Library.entity.Book;
import com.library.Book.Library.enums.BookGenre;
import com.library.Book.Library.exception.ResourceNotFoundException;
import com.library.Book.Library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    private final BookService bookService;

    @GetMapping("/")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Book with id " + id + " was not found"));
        return ResponseEntity.ok(book);
    }

    @GetMapping("/title")
    public ResponseEntity<List<Book>> getBooksByTitle(String title) {
        List<Book> bookList = bookService.findAllByTitleContaining(title);
        if (!bookList.isEmpty()) {
            return ResponseEntity.ok(bookList);
        } else {
            throw new ResourceNotFoundException("No book with this title was found");
        }
    }

    @GetMapping("/author")
    public ResponseEntity<List<Book>> getBooksByAuthor(Author author) {
        List<Book> bookList = bookService.findAllByAuthor(author);
        if (!bookList.isEmpty()) {
            return ResponseEntity.ok(bookList);
        } else {
            throw new ResourceNotFoundException("No book with this author was found");
        }
    }

    @GetMapping("/genre")
    public ResponseEntity<List<Book>> getBooksByGenre(BookGenre genre) {
        List<Book> bookList = bookService.findAllByGenre(genre);
        if (!bookList.isEmpty()) {
            return ResponseEntity.ok(bookList);
        } else {
            throw new ResourceNotFoundException("No book with this genre was found");
        }
    }

    @GetMapping("/publisher")
    public ResponseEntity<List<Book>> getBooksByPublisher(String publisher) {
        List<Book> bookList = bookService.findAllByPublisher(publisher);
        if (!bookList.isEmpty()) {
            return ResponseEntity.ok(bookList);
        } else {
            throw new ResourceNotFoundException("No book from this publisher was found");
        }
    }

    @GetMapping("/releaseDate")
    public ResponseEntity<List<Book>> getBooksByReleaseYearGreaterThan(Integer releaseYear) {
        List<Book> bookList = bookService.findAllByReleaseYearGreaterThan(releaseYear);
        if (!bookList.isEmpty()) {
            return ResponseEntity.ok(bookList);
        } else {
            throw new ResourceNotFoundException("No book released after this year was found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        bookService.update(id, updatedBook);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBook(@PathVariable Long id) {
        Book book = bookService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " was not found"));
        bookService.delete(book);
        Map<String, Boolean> response = new HashMap<>();
        return ResponseEntity.ok(response);
    }

}
