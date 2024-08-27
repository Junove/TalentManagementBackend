package com.example.talent_api.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.talent_api.entity.HiringManager;
import com.example.talent_api.entity.Job;
import com.example.talent_api.entity.User;

@SpringBootTest
public class JobRepositoryTest {
    @Autowired JobRepository jobRepo;
    @Autowired HiringManagerRepository managerRepo;
    @Autowired UserRepository userRepo;

    List<Job> jobs = new ArrayList<>();
    HiringManager manager;
    HiringManager manager2;

    @BeforeEach
    void init() {

        User user = new User();
        user.setId(1L);
        user.setUsername("username");
        user.setPassword("password");
        user.setType("candidate");
        userRepo.save(user);

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

        managerRepo.save(manager);
        managerRepo.save(manager2);

        for (int i = 1; i <= 5; i++) {
            Job job = new Job((i % 2) + 1,
            "Sales Division " + i,
            "Sales Associate Wanted!",
            "2024-08-01 10:00:00",
            "2024-08-01 12:00:00",
            "Sales Associate",
            "The candidate will participate in sales phonecalls from 9-5.",
            "Experience in sales recommended.",
            "Open"
            );
            job.setId(i);
            jobs.add(job);
        }
        jobRepo.saveAll(jobs);
    }

    @Test
    void findFirstById() {
        assertNotNull(jobs);

        Job job = jobRepo.findFirstById(4L);
        assertNotNull(job);
        assertEquals(jobs.get(3).getId(), job.getId());
        
        assertNull(jobRepo.findFirstById(0L));
    }

    @Test
    void findBymanagerID() {
        assertNotNull(jobs);
        assertEquals(2, jobRepo.findBymanagerID(1).size());
        assertEquals(3, jobRepo.findBymanagerID(2).size());
        assertEquals(0, jobRepo.findBymanagerID(0).size());
    }
}
