package com.example.talent_api.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CandidateTest {

    private Candidate candidate;
    private User user;

    @BeforeEach
    void init() {

        user = new User();
        user.setId(1L);
        user.setUsername("username");
        user.setPassword("password");
        user.setType("admin");

        candidate = new Candidate();
        candidate.setId(1L);
        candidate.setFullName("John Doe");
        candidate.setEmail("johndoe@email.com");
        candidate.setAddress("15 Doe Lane");
        candidate.setPhone("1234567890");
        candidate.setResume("This is where I would put my resume... if I had one!");
        candidate.setUser(user);
    }

    @Test
    void getId() {
        assertNotNull(candidate);
        assertEquals(1L,candidate.getId());
    }

    @Test
    void setId() {
        assertNotNull(candidate);
        assertEquals(1L,candidate.getId());
        candidate.setId(2L);
        assertEquals(2L,candidate.getId());
    }

    @Test
    void getFullName() {
        assertNotNull(candidate);
        assertEquals("John Doe",candidate.getFullName());
    }

    @Test
    void setFullName() {
        assertNotNull(candidate);
        assertEquals("John Doe",candidate.getFullName());
        candidate.setFullName("Jane Doe");
        assertEquals("Jane Doe",candidate.getFullName());
    }

    @Test
    void getEmail() {
        assertNotNull(candidate);
        assertEquals("johndoe@email.com",candidate.getEmail());
    }

    @Test
    void setEmail() {
        assertNotNull(candidate);
        assertEquals("johndoe@email.com",candidate.getEmail());
        candidate.setEmail("janedoe@email.com");
        assertEquals("janedoe@email.com",candidate.getEmail());
    }

    @Test
    void getAddress() {
        assertNotNull(candidate);
        assertEquals("15 Doe Lane",candidate.getAddress());
    }

    @Test
    void setAddress() {
        assertNotNull(candidate);
        assertEquals("15 Doe Lane",candidate.getAddress());
        candidate.setAddress("15 Dough Lane");
        assertEquals("15 Dough Lane",candidate.getAddress());
    }

    @Test
    void getPhone() {
        assertNotNull(candidate);
        assertEquals("1234567890",candidate.getPhone());
    }

    @Test
    void setPhone() {
        assertNotNull(candidate);
        assertEquals("1234567890",candidate.getPhone());
        candidate.setPhone("0987654321");
        assertEquals("0987654321",candidate.getPhone());
    }

    @Test
    void getResume() {
        assertNotNull(candidate);
        assertEquals("This is where I would put my resume... if I had one!",candidate.getResume());
    }

    @Test
    void setResume() {
        assertNotNull(candidate);
        assertEquals("This is where I would put my resume... if I had one!",candidate.getResume());
        candidate.setResume("Experience: 5 years of Python dev, etc.");
        assertEquals("Experience: 5 years of Python dev, etc.",candidate.getResume());
    }

    @Test
    void getUser() {
        assertNotNull(candidate);
        assertNotNull(user);
        assertEquals(user,candidate.getUser());
    }

    @Test
    void setUser() {

        User user2 = new User();
        user2.setId(2L);
        user2.setUsername("user2");
        user2.setPassword("pass2");
        user2.setType("user");

        assertNotNull(candidate);
        assertEquals(user,candidate.getUser());
        candidate.setUser(user2);
        assertEquals(user2, candidate.getUser());
        assertEquals(2L, user2.getId());
        assertEquals("user2", user2.getUsername());
        assertEquals("pass2", user2.getPassword());
        assertEquals("user", user2.getType());
    }
}
