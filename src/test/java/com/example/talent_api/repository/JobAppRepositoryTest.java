package com.example.talent_api.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.talent_api.entity.JobApp;

@SpringBootTest
public class JobAppRepositoryTest {
    @Autowired JobAppRepository repo;
    

    @BeforeEach
    void init() {
        User user = new User();
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
        candidate.setResume("This is my short resume.");
        candidate.setUser(user);

        candidate2 = new Candidate();
        candidate2.setId(2L);
        candidate2.setFullName("Jane Doe");
        candidate2.setEmail("janedoe@email.com");
        candidate2.setAddress("15 Doe Lane");
        candidate2.setPhone("0987654321");
        candidate2.setResume("My resume is quite long: ...");
        candidate2.setUser(user);

        repo.save(candidate);
        repo.save(candidate2);
    }

    @Test
    void findFirstByEmail() {
        assertNotNull(candidate);
        assertNotNull(candidate2);

        assertEquals(candidate.getEmail(), repo.findFirstByEmail("johndoe@email.com").getEmail());
        assertEquals(candidate2.getEmail(), repo.findFirstByEmail("janedoe@email.com").getEmail());
        assertNull(repo.findFirstByEmail("emaildoesn'tmatch"));

    }

    @Test
    void findFirstById() {
        assertNotNull(candidate);
        assertNotNull(candidate2);

        assertEquals(candidate.getId(), repo.findFirstById(1L).getId());
        assertEquals(candidate2.getId(), repo.findFirstById(2L).getId());
        assertNull(repo.findFirstById(0L));

    }
}
