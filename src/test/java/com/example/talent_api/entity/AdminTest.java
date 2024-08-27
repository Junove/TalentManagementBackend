package com.example.talent_api.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminTest {

    private Admin admin;
    private User user;

    @BeforeEach
    void init() {
        user = new User();
        user.setId(1L);
        user.setUsername("username");
        user.setPassword("password");
        user.setType("admin");

        admin = new Admin();
        admin.setId(1L);
        admin.setName("John Doe");
        admin.setEmail("johndoe@email.com");
        admin.setUser(user);
    }

    @Test
    void getId() {
        assertNotNull(admin);
        assertEquals(1L,admin.getId());
    }

    @Test
    void setId() {
        assertNotNull(admin);
        assertEquals(1L,admin.getId());
        admin.setId(2L);
        assertEquals(2L,admin.getId());
    }

    @Test
    void getName() {
        assertNotNull(admin);
        assertEquals("John Doe",admin.getName());
    }

    @Test
    void setName() {
        assertNotNull(admin);
        assertEquals("John Doe",admin.getName());
        admin.setName("Jane Doe");
        assertEquals("Jane Doe",admin.getName());
    }

    @Test
    void getEmail() {
        assertNotNull(admin);
        assertEquals("johndoe@email.com",admin.getEmail());
    }

    @Test
    void setEmail() {
        assertNotNull(admin);
        assertEquals("johndoe@email.com",admin.getEmail());
        admin.setEmail("janedoe@email.com");
        assertEquals("janedoe@email.com",admin.getEmail());
    }

    @Test
    void getUser() {
        assertNotNull(admin);
        assertNotNull(user);
        assertEquals(user,admin.getUser());
    }

    @Test
    void setUser() {
        User user2 = new User();
        user2.setId(2L);
        user2.setUsername("user2");
        user2.setPassword("pass2");
        user2.setType("user");

        assertNotNull(admin);
        assertEquals(user,admin.getUser());
        admin.setUser(user2);
        assertEquals(user2, admin.getUser());
        assertEquals(2L, user2.getId());
        assertEquals("user2", user2.getUsername());
        assertEquals("pass2", user2.getPassword());
        assertEquals("user", user2.getType());
    }

}
