package com.example.talent_api.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.talent_api.entity.User;


@SpringBootTest
public class UserRepositoryTest {


    @Test
    public void testSaveAndFind(@Autowired UserRepository repo) {

        User u = new User();
        u.setPassword("pw");
        u.setType("candidate");
        u.setUsername("xy");

        repo.save(u);

        Optional<User> result = repo.findUserById(u.getId());
        User user = result.get();
        assertEquals(user.getPassword(), u.getPassword());
        assertEquals(user.getType(), u.getType());
        assertEquals(user.getUsername(), u.getUsername());

        repo.delete(user);
    }
}