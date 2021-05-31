package com.library.Book.Library.controller;

import com.library.Book.Library.entity.User;
import com.library.Book.Library.exception.ResourceNotFoundException;
import com.library.Book.Library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User with id " + id + " was not found"));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/email")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email).orElseThrow(() ->
                new ResourceNotFoundException("User with email " + email + " was not found"));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/firstNameAndLastName")
    public ResponseEntity<User> getUserByFirstNameAndLastName(String firstName, String lastName) {
        User user = userService.findByFirstNameAndLastName(firstName, lastName).orElseThrow(() ->
                new ResourceNotFoundException("User with name " + firstName + " " + lastName + " was not found"));
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        userService.update(id, updatedUser);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {
        User user = userService.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " was not found"));
        userService.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        return ResponseEntity.ok(response);
    }


}
