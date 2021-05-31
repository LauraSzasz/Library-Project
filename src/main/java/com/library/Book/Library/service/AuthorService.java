package com.library.Book.Library.service;

import com.library.Book.Library.entity.Author;
import com.library.Book.Library.exception.ResourceNotFoundException;
import com.library.Book.Library.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAllByOrderByLastNameAsc();
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    public List<Author> findByLastName(String lastName) {
        return authorRepository.findAllByLastName(lastName);
    }

    public void update(Long id, Author newAuthor) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent()) {
            Author oldAuthor = author.get();
            oldAuthor.setFirstName(newAuthor.getFirstName());
            oldAuthor.setLastName(newAuthor.getLastName());
            oldAuthor.setDateOfBirth(newAuthor.getDateOfBirth());
        } else {
            throw new ResourceNotFoundException("Author was not found");
        }
    }

    public void delete(Author author) {
        authorRepository.delete(author);
    }
}
