package com.example.talent_api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import com.example.talent_api.entity.JobApp;

@SpringBootTest
public class JobAppRepositoryTest {
    
    @Autowired private JobAppRepository jobAppRepo;

    @BeforeEach
    void init(){
        JobApp jobApp = new JobApp();
        assertNotNull(jobApp);

        jobApp.setCandidate_id(1); 
        jobApp.setJob_id(1); 
        jobApp.setDate_applied("2024-08-18 11:45:00");
        jobApp.setCover_letter("Cover letter 1");
        jobApp.setCustom_resume("Custom resume 1");
        jobApp.setApplication_status("Open");

        JobApp jobApp2 = new JobApp();
        assertNotNull(jobApp2);

        jobApp2.setCandidate_id(1); 
        jobApp2.setJob_id(2); 
        jobApp2.setDate_applied("2024-08-18 11:46:00");
        jobApp2.setCover_letter("Cover letter 2");
        jobApp2.setCustom_resume("Custom resume 2");
        jobApp2.setApplication_status("Closed");

        JobApp jobApp3 = new JobApp();
        assertNotNull(jobApp3);

        jobApp3.setCandidate_id(2); 
        jobApp3.setJob_id(1); 
        jobApp3.setDate_applied("2024-08-18 11:49:00");
        jobApp3.setCover_letter("Cover letter 3");
        jobApp3.setCustom_resume("Custom resume 3");
        jobApp3.setApplication_status("Open");

        jobAppRepo.save(jobApp);
        jobAppRepo.save(jobApp2);
        jobAppRepo.save(jobApp3);
    }

    @Test
    void findByJobId(){
        int num = 1;
        long job_id = (long) num;
        List<JobApp> target = jobAppRepo.findByjobId(job_id);

        assertNotNull(target);
        assertEquals(target.get(0).getJob_id(), 1);
    }

    @Test
    void findAllBycandidateId(){
        int num = 2;
        long job_id = (long) num;
        List<JobApp> target = jobAppRepo.findByjobId(job_id);

        assertNotNull(target);
        assertEquals(target.get(0).getJob_id(), 2);
    }
}
