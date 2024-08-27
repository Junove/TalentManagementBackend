package com.example.talent_api.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.talent_api.entity.HiringManager;
import com.example.talent_api.entity.User;

@SpringBootTest
public class HiringManagerRepositoryTest {
    @Autowired HiringManagerRepository repo;
    HiringManager manager;
    HiringManager manager2;

    @BeforeEach
    void init() {
        User user = new User();
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

        manager2 = new HiringManager();
        manager2.setId(2L);
        manager2.setName("Jane Doe");
        manager2.setEmail("janedoe@email.com");
        manager2.setDepartment("Sales 2");
        manager2.setPhone("0987654321");
        manager2.setUser(user);

        repo.save(manager);
        repo.save(manager2);
    }

    @Test
    void findFirstByEmail() {
        assertNotNull(manager);
        assertNotNull(manager2);

        assertEquals(manager.getEmail(), repo.findFirstByEmail("johndoe@email.com").getEmail());
        assertEquals(manager2.getEmail(), repo.findFirstByEmail("janedoe@email.com").getEmail());
        assertNull(repo.findFirstByEmail("email doesn'tmatch"));
    }
}
