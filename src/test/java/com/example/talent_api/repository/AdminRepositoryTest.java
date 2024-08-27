package com.example.talent_api.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.talent_api.entity.Admin;
import com.example.talent_api.entity.User;

@SpringBootTest
public class AdminRepositoryTest {
    @Autowired AdminRepository repo;
    private Admin admin;
    private Admin admin2;
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

        admin2 = new Admin();
        admin2.setId(2L);
        admin2.setName("Jane Doe");
        admin2.setEmail("janedoe@email.com");
        admin2.setUser(user);

        repo.save(admin);
        repo.save(admin2);
    }

    @Test
    void findFirstByEmail() {
        assertNotNull(admin);
        assertNotNull(admin2);

        assertEquals(admin.getEmail(), repo.findFirstByEmail("johndoe@email.com").getEmail());
        assertEquals(admin2.getEmail(), repo.findFirstByEmail("janedoe@email.com").getEmail());
        assertNull(repo.findFirstByEmail("email doesn'tmatch"));
    }
}
