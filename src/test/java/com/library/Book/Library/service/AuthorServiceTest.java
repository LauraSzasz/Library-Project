package com.library.Book.Library.service;

import com.library.Book.Library.entity.Author;
import com.library.Book.Library.repository.AuthorRepository;
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
class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;
    @InjectMocks
    private AuthorService authorService;
    @Mock
    private Author authorMock;
    @Mock
    private Author newAuthorMock;


    @Test
    void findAll() {
        List<Author> authorListMock = new ArrayList<>();
        authorListMock.add(authorMock);
        authorListMock.add(newAuthorMock);
        when(authorRepository.findAllByOrderByLastNameAsc()).thenReturn(authorListMock);
        List<Author> authorList = authorService.findAll();
        assertEquals(2, authorList.size());
        verify(authorRepository, atLeastOnce()).findAllByOrderByLastNameAsc();

    }

    @Test
    void addAuthor() {
        when(authorRepository.save(authorMock)).thenReturn(authorMock);
        final Author addedAuthor = authorService.addAuthor(authorMock);
        assertThat(addedAuthor).isEqualTo(authorMock);
        verify(authorRepository, atLeastOnce()).save(authorMock);

    }

    @Test
    void findById() {
        Long id = 1L;
        authorMock.setId(id);
        when(authorRepository.findById(id)).thenReturn(Optional.of(authorMock));
        Optional<Author> author = authorService.findById(id);
        assertEquals(authorMock, author.get());
        verify(authorRepository, atLeastOnce()).findById(id);
    }

    @Test
    void findByLastName() {
        List<Author> authorListMock = new ArrayList<>();
        authorMock.setLastName("TestName");
        authorListMock.add(authorMock);
        when(authorRepository.findAllByLastName("TestName")).thenReturn(authorListMock);
        List<Author> authorList = authorService.findByLastName("TestName");
        assertEquals(authorList, authorListMock);
        verify(authorRepository, atLeastOnce()).findAllByLastName("TestName");

    }

    @Test
    void findByWrongLastName() {
        List<Author> authorListMock = new ArrayList<>();
        authorMock.setLastName("TestName");
        authorListMock.add(authorMock);
        lenient().when(authorRepository.findAllByLastName("TestName")).thenReturn(authorListMock);
        List<Author> authorList = authorService.findByLastName("AnotherName");
        assertTrue(authorList.isEmpty());
        verify(authorRepository, atLeastOnce()).findAllByLastName("AnotherName");

    }

    @Test
    void update() {
        Long id = 1L;
        authorMock.setId(id);
        when(authorRepository.findById(id)).thenReturn(Optional.of(authorMock));
        authorService.update(id, newAuthorMock);
        verify(authorRepository, atLeastOnce()).findById(id);
    }

    @Test
    void delete() {
        authorService.delete(authorMock);
        verify(authorRepository, atLeastOnce()).delete(authorMock);
    }
}