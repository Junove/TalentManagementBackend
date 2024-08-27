package com.example.talent_api.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    private User user  = new User();

    @BeforeEach
    void setUp() {
        user.setId(1);
        user.setPassword("pw");
        user.setType("candidate");
        user.setUsername("xy");
    }

    @Test
    public void testId() {
        assertEquals(1, user.getId());
    }

    @Test
    public void testUsername() {
        assertEquals("xy", user.getUsername());
    }

    @Test
    public void testPassword() {
        assertEquals("pw", user.getPassword());
    }

    @Test
    public void testType() {
        assertEquals("candidate", user.getType());
    }
    
}