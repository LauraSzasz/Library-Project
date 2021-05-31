package com.library.Book.Library.controller;

import com.library.Book.Library.entity.Author;
import com.library.Book.Library.exception.ResourceNotFoundException;
import com.library.Book.Library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/")
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @PostMapping("/add")
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Author author = authorService.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Author with id " + id + " was not found"));
        return ResponseEntity.ok(author);
    }

    @GetMapping("/lastName/{lastName}")
    public ResponseEntity<List<Author>> findAuthorByLastName(@PathVariable String lastName) {
        List<Author> authorList = authorService.findByLastName(lastName);
        if (!authorList.isEmpty()) {
            return ResponseEntity.ok(authorList);
        } else {
            throw new ResourceNotFoundException("No author with last name " + lastName + " found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author updatedAuthor) {
        authorService.update(id, updatedAuthor);
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAuthor(@PathVariable Long id) {
        Author author = authorService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + " was not found"));
        authorService.delete(author);
        Map<String, Boolean> response = new HashMap<>();
        return ResponseEntity.ok(response);
    }

}
