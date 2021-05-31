package com.library.Book.Library.repository;

import com.library.Book.Library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAllByOrderByLastNameAsc();

    List<Author> findAllByLastName(String lastName);

}
