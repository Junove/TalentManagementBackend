package com.example.talent_api.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JobAppTest {

    private JobApp jobApp;

    @BeforeEach
    void init() {
        jobApp = new JobApp();
        jobApp.setId(1L);
        jobApp.setApplication_status("You shall be tested");
        jobApp.setCandidate_id(1);
        jobApp.setCover_letter("I am very qualified for this job");
        jobApp.setCustom_resume("Such a qualified resume");
        jobApp.setDate_applied("2024-08-18 11:45:00");
        jobApp.setJob_id(3);
    }

    @Test
    void getId() {
        assertNotNull(jobApp);
        assertEquals(1L,jobApp.getId());
    }

    @Test
    void setId() {
        assertNotNull(jobApp);
        assertEquals(1L,jobApp.getId());
        jobApp.setId(2L);
        assertEquals(2L,jobApp.getId());
    }

    @Test
    void getApplication_status() {
        assertNotNull(jobApp);
        assertEquals("You shall be tested",jobApp.getApplication_status());
    }

    @Test
    void setApplication_status() {
        assertNotNull(jobApp);
        assertEquals("You shall be tested",jobApp.getApplication_status());
        jobApp.setApplication_status("You have been tested");
        assertEquals("You have been tested",jobApp.getApplication_status());
    }

    @Test
    void getCandidate_id() {
        assertNotNull(jobApp);
        assertEquals(1,jobApp.getCandidate_id());
    }

    @Test
    void setCandidate_id() {
        assertNotNull(jobApp);
        assertEquals(1,jobApp.getCandidate_id());
        jobApp.setCandidate_id(2);
        assertEquals(2,jobApp.getCandidate_id());
    }
    


    @Test
    void testGetCover_letter() {
        
    }

    @Test
    void testGetCustom_resume() {
        
    }

    @Test
    void testGetDate_applied() {
        
    }

    @Test
    void testGetId() {
        
    }

    @Test
    void testGetJob_id() {
        
    }

    @Test
    void testSetCover_letter() {
        
    }

    @Test
    void testSetCustom_resume() {
        
    }

    @Test
    void testSetDate_applied() {
        
    }

    @Test
    void testSetId() {
        
    }

    @Test
    void testSetJob_id() {
        
    }
}
