package com.library.Book.Library.service;

import com.library.Book.Library.entity.User;
import com.library.Book.Library.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;
    @Mock
    private User userMock;
    @Mock
    private User newUserMock;

    @Test
    void findAll() {
        List<User> userListMock = new ArrayList<>();
        userListMock.add(userMock);
        when(userRepository.findAllByOrderByLastNameAsc()).thenReturn(userListMock);
        List<User> userList = userService.findAll();
        assertEquals(userList, userListMock);
        verify(userRepository, atLeastOnce()).findAllByOrderByLastNameAsc();
    }

    @Test
    void addUser() {
        when(userRepository.save(userMock)).thenReturn(userMock);
        User user = userService.addUser(userMock);
        assertEquals(user, userMock);
        verify(userRepository, atLeastOnce()).save(userMock);
    }

    @Test
    void findById() {
        Long id = 1L;
        userMock.setId(id);
        when(userRepository.findById(id)).thenReturn(Optional.of(userMock));
        Optional<User> user = userService.findById(id);
        assertEquals(userMock, user.get());
        verify(userRepository, atLeastOnce()).findById(id);
    }

    @Test
    void findByEmail() {
        String email = "email@mock.com";
        userMock.setEmail(email);
        when(userRepository.findByEmail(email)).thenReturn(Optional.of(userMock));
        Optional<User> user = userService.findByEmail(email);
        assertEquals(userMock, user.get());
        verify(userRepository, atLeastOnce()).findByEmail(email);
    }


    @Test
    void update() {
        Long id = 1L;
        userMock.setId(id);
        when(userRepository.findById(id)).thenReturn(Optional.of(userMock));
        userService.update(id, newUserMock);
        verify(userRepository, atLeastOnce()).findById(id);
    }

    @Test
    void delete() {
        userService.delete(userMock);
        verify(userRepository, atLeastOnce()).delete(userMock);
    }
}