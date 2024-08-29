package com.example.talent_api.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.List;


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
import com.example.talent_api.repository.HiringManagerRepository;
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

    @MockBean
    private HiringManagerRepository managerRepository; 

   
   
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

    job = new Job("GETS", "GPT", "Adp Coder", "No Info");
    job.setId(4L);
    job.setManager_id(1);
    
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


@Test
public void testPost() throws Exception {
    
  
    when(jobRepository.save(any(Job.class))).thenReturn(job);

    mockMvc.perform(post("/jobs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(job)))
        .andExpect(status().isCreated())
        .andDo(print())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id").value(4))
        .andExpect(jsonPath("$.manager_id").value(1))
        .andExpect(jsonPath("$.job_title").value("GPT"))
        .andExpect(jsonPath("$.job_description").value("Adp Coder"))
        .andExpect(jsonPath("$.additional_information").value("No Info"));
}



    @Test
    public void testPut() throws Exception{
        Job newJob = new Job("Update_Dep", "Update_Title", "Update_Desc", "Update_Info"); 
        newJob.setId(4L);
        newJob.setManager_id(1);
        when(jobRepository.findFirstById(anyLong())).thenReturn((job));
        when(jobRepository.save(any(Job.class))).thenReturn(newJob);

        mockMvc.perform(put("/jobs/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(newJob)))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(4))  
            .andExpect(jsonPath("$.department").value("Update_Dep"))  
            .andExpect(jsonPath("$.job_title").value("Update_Title"))
            .andExpect(jsonPath("$.job_description").value("Update_Desc"))
            .andExpect(jsonPath("$.additional_information").value("Update_Info")); 
    }



        

@Test
void deleteJobListing() throws Exception {
    // Configure mock behavior
    when(jobRepository.findFirstById(0L)).thenReturn(null);
    when(jobRepository.findFirstById(1L)).thenReturn(job);
    doNothing().when(jobRepository).delete(any(Job.class));


    mockMvc.perform(delete("/jobs/0")
            .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isNotFound()); 

  
    mockMvc.perform(delete("/jobs/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isNoContent()); 
}


   
 
    
    



}

   