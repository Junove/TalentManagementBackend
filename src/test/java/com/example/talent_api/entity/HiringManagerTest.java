package com.example.talent_api.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HiringManagerTest {

    private HiringManager manager;
    private User user;

    @BeforeEach
    void init() {

        user = new User();
        user.setId(1L);
        user.setUsername("username");
        user.setPassword("password");
        user.setType("admin");

        manager = new HiringManager();
        manager.setId(1L);
        manager.setName("John Doe");
        manager.setEmail("johndoe@email.com");
        manager.setDepartment("Sales");
        manager.setPhone("1234567890");
        manager.setUser(user);
    }

    @Test
    void getId() {
        assertNotNull(manager);
        assertEquals(1L,manager.getId());
    }

    @Test
    void setId() {
        assertNotNull(manager);
        assertEquals(1L,manager.getId());
        manager.setId(2L);
        assertEquals(2L,manager.getId());
    }

    @Test
    void getName() {
        assertNotNull(manager);
        assertEquals("John Doe",manager.getName());
    }

    @Test
    void setName() {
        assertNotNull(manager);
        assertEquals("John Doe",manager.getName());
        manager.setName("Jane Doe");
        assertEquals("Jane Doe",manager.getName());
    }

    @Test
    void getEmail() {
        assertNotNull(manager);
        assertEquals("johndoe@email.com",manager.getEmail());
    }

    @Test
    void setEmail() {
        assertNotNull(manager);
        assertEquals("johndoe@email.com",manager.getEmail());
        manager.setEmail("janedoe@email.com");
        assertEquals("janedoe@email.com",manager.getEmail());
    }

    @Test
    void getDepartment() {
        assertNotNull(manager);
        assertEquals("Sales",manager.getDepartment());
    }

    @Test
    void setDepartment() {
        assertNotNull(manager);
        assertEquals("Sales",manager.getDepartment());
        manager.setDepartment("Evil Sales");
        assertEquals("Evil Sales",manager.getDepartment());
    }

    @Test
    void getPhone() {
        assertNotNull(manager);
        assertEquals("1234567890",manager.getPhone());
    }

    @Test
    void setPhone() {
        assertNotNull(manager);
        assertEquals("1234567890",manager.getPhone());
        manager.setPhone("0987654321");
        assertEquals("0987654321",manager.getPhone());
    }

    @Test
    void getUser() {
        assertNotNull(manager);
        assertNotNull(user);
        assertEquals(user,manager.getUser());
    }

    @Test
    void setUser() {

        User user2 = new User();
        user2.setId(2L);
        user2.setUsername("user2");
        user2.setPassword("pass2");
        user2.setType("user");

        assertNotNull(manager);
        assertEquals(user,manager.getUser());
        manager.setUser(user2);
        assertEquals(user2, manager.getUser());
        assertEquals(2L, user2.getId());
        assertEquals("user2", user2.getUsername());
        assertEquals("pass2", user2.getPassword());
        assertEquals("user", user2.getType());
    }
}
