package com.example.talent_api.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.talent_api.entity.Job;
import com.example.talent_api.repository.JobRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(JobsController.class)
public class JobsControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    private List<Job> jobs;

    private Job job;

    @MockBean
    private JobRepository jobRepository;

   
   
@BeforeEach
public void setUp() {
    jobs = new ArrayList<>();
    Job job1 = new Job("Department", "title1", "descr", "additional");
    job1.setId(1L);
    job1.setManager_id(1);
    jobs.add(job1);

    Job job2 = new Job("Department2", "title2", "descr2", "additional2");
    job2.setId(2L); 
    job2.setManager_id(1);
    jobs.add(job2);

    Job job3 = new Job("Engineer", "Smart", "Engineer and Smart", "No Info");
    job3.setId(3L); 
    job3.setManager_id(2);
    jobs.add(job3);
}

    @Test
    public void testGetAll() throws Exception {
        when(jobRepository.findAll()).thenReturn(jobs);

        mockMvc.perform(get("/jobs"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[1].id").value(2))
            .andExpect(jsonPath("$[0].manager_id").value(1))
            .andExpect(jsonPath("$[1].job_description").value("descr2"))
            .andExpect(jsonPath("$[0].job_description").value("descr"));
    }


    @Test
    public void testGetOne() throws Exception {

        when(jobRepository.findFirstById(anyLong())).thenReturn((jobs.get(0)));

        mockMvc.perform(get("/jobs/1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.manager_id").value(1))
            .andExpect(jsonPath("$.job_title").value("title1"))
            .andExpect(jsonPath("$.department").value("Department"));
         
    }

}

   