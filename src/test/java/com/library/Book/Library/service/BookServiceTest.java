package com.library.Book.Library.service;

import com.library.Book.Library.entity.Book;
import com.library.Book.Library.enums.BookGenre;
import com.library.Book.Library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BookService bookService;
    @Mock
    private Book bookMock;
    @Mock
    private Book newBookMock;

    @Test
    void addBook() {
        when(bookRepository.save(bookMock)).thenReturn(bookMock);
        final Book addedBook = bookService.addBook(bookMock);
        assertThat(addedBook).isEqualTo(bookMock);
        verify(bookRepository, atLeastOnce()).save(bookMock);

    }

    @Test
    void findById() {
        Long id = 1L;
        bookMock.setId(id);
        when(bookRepository.findById(id)).thenReturn(Optional.of(bookMock));
        Optional<Book> book = bookService.findById(id);
        assertEquals(bookMock, book.get());
        verify(bookRepository, atLeastOnce()).findById(id);
    }

    @Test
    void findAll() {
        List<Book> bookListMock = new ArrayList<>();
        bookListMock.add(bookMock);
        bookListMock.add(newBookMock);
        when(bookRepository.findAllByOrderByTitleAsc()).thenReturn(bookListMock);
        List<Book> bookList = bookService.findAll();
        assertEquals(bookList, bookListMock);
        verify(bookRepository, atLeastOnce()).findAllByOrderByTitleAsc();

    }

    @Test
    void findAllByTitleContaining() {
        List<Book> bookListMock = new ArrayList<>();
        bookMock.setTitle("SomeName");
        bookListMock.add(bookMock);
        when(bookRepository.findAllByTitleContaining("SomeName")).thenReturn(bookListMock);
        List<Book> bookList = bookService.findAllByTitleContaining("SomeName");
        assertEquals(bookList, bookListMock);
        verify(bookRepository, atLeastOnce()).findAllByTitleContaining("SomeName");
    }

    @Test
    void findAllByGenre() {
        List<Book> bookListMock = new ArrayList<>();
        bookMock.setGenre(BookGenre.HISTORY);
        bookListMock.add(bookMock);
        when(bookRepository.findAllByGenre(BookGenre.HISTORY)).thenReturn(bookListMock);
        List<Book> bookList = bookService.findAllByGenre(BookGenre.HISTORY);
        assertEquals(bookList, bookListMock);
        verify(bookRepository, atLeastOnce()).findAllByGenre(BookGenre.HISTORY);
    }


    @Test
    void update() {
        Long id = 1L;
        bookMock.setId(id);
        when(bookRepository.findById(id)).thenReturn(Optional.of(bookMock));
        bookService.update(id, newBookMock);
        verify(bookRepository, atLeastOnce()).findById(id);
    }

    @Test
    void delete() {
        bookService.delete(bookMock);
        verify(bookRepository, atLeastOnce()).delete(bookMock);
    }
}