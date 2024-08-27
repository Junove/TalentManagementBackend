package com.example.talent_api.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.talent_api.entity.User;


@SpringBootTest
public class UserRepositoryTest {
    @Autowired UserRepository repo;
    User user;
    User user2;

    @BeforeEach
    void init() {
        user = new User();
        user.setId(1L);
        user.setUsername("username");
        user.setPassword("password");
        user.setType("admin");
        repo.save(user);

        user2 = new User();
        user2.setId(2L);
        user2.setUsername("user2");
        user2.setPassword("pass2");
        user2.setType("candidate");
        repo.save(user2);
    }

    @Test
    public void findUserById() {
        assertNotNull(user);
        assertNotNull(user2);

        User test = repo.findUserById(user.getId());
        assertEquals(user.getPassword(), test.getPassword());
        assertEquals(user.getType(), test.getType());
        assertEquals(user.getUsername(), test.getUsername());

        User test2 = repo.findUserById(user2.getId());
        assertEquals(user2.getPassword(), test2.getPassword());
        assertEquals(user2.getType(), test2.getType());
        assertEquals(user2.getUsername(), test2.getUsername());
    }

    @Test
    public void findByUsername() {
        assertNotNull(user);
        assertNotNull(user2);

        User test = repo.findByUsername(user.getUsername());
        assertEquals(user.getPassword(), test.getPassword());
        assertEquals(user.getType(), test.getType());
        assertEquals(user.getUsername(), test.getUsername());

        User test2 = repo.findByUsername(user2.getUsername());
        assertEquals(user2.getPassword(), test2.getPassword());
        assertEquals(user2.getType(), test2.getType());
        assertEquals(user2.getUsername(), test2.getUsername());
    }
}