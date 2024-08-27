package com.example.talent_api.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CredentialsTest {

    private Credentials credentials;

    @BeforeEach
    void init() {

        credentials = new Credentials("username", "password");
    }

    @Test
    void getUsername() {
        assertNotNull(credentials);
        assertEquals("username",credentials.getUsername());
    }

    @Test
    void setUsername() {
        assertNotNull(credentials);
        assertEquals("username",credentials.getUsername());
        credentials.setUsername("new username");
        assertEquals("new username",credentials.getUsername());
    }

    @Test
    void getPassword() {
        assertNotNull(credentials);
        assertEquals("password",credentials.getPassword());
    }

    @Test
    void setPassword() {
        assertNotNull(credentials);
        assertEquals("password",credentials.getPassword());
        credentials.setPassword("new password");
        assertEquals("new password",credentials.getPassword());
    }

}
