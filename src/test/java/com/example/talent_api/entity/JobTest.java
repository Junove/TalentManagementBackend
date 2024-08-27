package com.example.talent_api.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JobTest {

    private Job job;

    @BeforeEach
    void init() {
        job = new Job(1,
        "Sales Division",
        "Sales Associate Wanted!",
        "2024-08-01 10:00:00",
        "2024-10-01 10:00:00",
        "Sales Associate",
        "The candidate will participate in sales phonecalls from 9-5.",
        "Experience in sales recommended.",
        "Open"
        );
        job.setId(1);
    }

    @Test
    void getId() {
        assertNotNull(job);
        assertEquals(1,job.getId());
    }

    @Test
    void setId() {
        assertNotNull(job);
        assertEquals(1,job.getId());
        job.setId(2);
        assertEquals(2,job.getId());
    }

    @Test
    void getManager_id() {
        assertNotNull(job);
        assertEquals(1,job.getManager_id());
    }

    @Test
    void setManager_id() {
        assertNotNull(job);
        assertEquals(1,job.getManager_id());
        job.setManager_id(2);
        assertEquals(2,job.getManager_id());
    }

    @Test
    void getDepartment() {
        assertNotNull(job);
        assertEquals("Sales Division",job.getDepartment());
    }

    @Test
    void setDepartment() {
        assertNotNull(job);
        assertEquals("Sales Division",job.getDepartment());
        job.setDepartment("Evil Sales Division");
        assertEquals("Evil Sales Division",job.getDepartment());
    }

    @Test
    void getListing_title() {
        assertNotNull(job);
        assertEquals("Sales Associate Wanted!",job.getListing_title());
    }

    @Test
    void setListing_title() {
        assertNotNull(job);
        assertEquals("Sales Associate Wanted!",job.getListing_title());
        job.setListing_title("Evil Sales Associate Wanted!");
        assertEquals("Evil Sales Associate Wanted!",job.getListing_title());
    }

    @Test
    void getDate_listed() {
        assertNotNull(job);
        assertEquals("2024-08-01 10:00:00",job.getDate_listed());
    }

    @Test
    void setDate_listed() {
        assertNotNull(job);
        assertEquals("2024-08-01 10:00:00",job.getDate_listed());
        job.setDate_listed("2024-08-02 10:00:00");
        assertEquals("2024-08-02 10:00:00",job.getDate_listed());
    }

    @Test
    void getDate_closed() {
        assertNotNull(job);
        assertEquals("2024-10-01 10:00:00",job.getDate_closed());
    }

    @Test
    void setDate_closed() {
        assertNotNull(job);
        assertEquals("2024-10-01 10:00:00",job.getDate_closed());
        job.setDate_closed("2024-10-02 10:00:00");
        assertEquals("2024-10-02 10:00:00",job.getDate_closed());
    }

    @Test
    void getJob_title() {
        assertNotNull(job);
        assertEquals("Sales Associate",job.getJob_title());
    }

    @Test
    void setJob_title() {
        assertNotNull(job);
        assertEquals("Sales Associate",job.getJob_title());
        job.setJob_title("Evil Sales Associate");
        assertEquals("Evil Sales Associate",job.getJob_title());
    }

    @Test
    void getJob_description() {
        assertNotNull(job);
        assertEquals("The candidate will participate in sales phonecalls from 9-5.",job.getJob_description());
    }

    @Test
    void setJob_description() {
        assertNotNull(job);
        assertEquals("The candidate will participate in sales phonecalls from 9-5.",job.getJob_description());
        job.setJob_description("The candidate will participate in evil sales phonecalls from 9-5.");
        assertEquals("The candidate will participate in evil sales phonecalls from 9-5.",job.getJob_description());
    }

    @Test
    void getAdditional_information() {
        assertNotNull(job);
        assertEquals("Experience in sales recommended.",job.getAdditional_information());
    }

    @Test
    void setAdditional_information() {
        assertNotNull(job);
        assertEquals("Experience in sales recommended.",job.getAdditional_information());
        job.setAdditional_information("Experience in evil sales recommended.");
        assertEquals("Experience in evil sales recommended.",job.getAdditional_information());
    }

    @Test
    void getListing_status() {
        assertNotNull(job);
        assertEquals("Open",job.getListing_status());
    }

    @Test
    void setListing_status() {
        assertNotNull(job);
        assertEquals("Open",job.getListing_status());
        job.setListing_status("Closed");
        assertEquals("Closed",job.getListing_status());
    }

}