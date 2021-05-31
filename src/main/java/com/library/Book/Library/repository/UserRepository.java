package com.library.Book.Library.repository;

import com.library.Book.Library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    List<User> findAllByOrderByLastNameAsc();

    Optional<User> findByEmail(@NotEmpty String email);

    Optional<User> findById(@NotEmpty Long id);

    Optional<User> findByFirstNameAndLastName(String firstName, String lastName);
}
