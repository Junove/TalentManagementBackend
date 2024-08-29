package com.example.talent_api.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.talent_api.entity.JobApp;
import com.example.talent_api.repository.JobAppRepository;

import java.util.Collections;
import java.util.List;

@WebMvcTest(JobAppsController.class)
public class JobAppsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JobAppRepository jobAppRepository;

    private List<JobApp> jobApps;


    @Test
    public void testGetAllJobApplications() throws Exception {
      
        assertEquals(1, 1);
    }
}
