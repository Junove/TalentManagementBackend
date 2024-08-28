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

import com.example.talent_api.entity.User;
import com.example.talent_api.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(UserController.class)
public class UserControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    private List<User> users;

    private User user;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        users = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("1");
        user1.setPassword("1");
        user1.setType("admin");
        users.add(user1);

        User user2 = new User();
        user2.setId(2);
        user2.setUsername("2");
        user2.setPassword("2");
        user2.setType("candidate");
        users.add(user2);

        User user3 = new User();
        user3.setId(3);
        user3.setUsername("3");
        user3.setPassword("3");
        user3.setType("hiring manager");
        users.add(user3);

        user = new User();
        user.setId(4);
        user.setUsername("4");
        user.setPassword("4");
        user.setType("admin");
    }

    @Test
    public void testGetAll() throws Exception {
        when(userRepository.findAll()).thenReturn(users);

        mockMvc.perform(get("/users"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[1].username").value("2"))
            .andExpect(jsonPath("$[2].type").value("hiring manager"));
    }

    @Test
    public void testGetOne() throws Exception {

        when(userRepository.findById(anyLong())).thenReturn(Optional.of(users.get(0)));

        mockMvc.perform(get("/users/1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.username").value("1"))
            .andExpect(jsonPath("$.password").value("1"))
            .andExpect(jsonPath("$.type").value("admin"));
    }

    @Test
    public void testPost() throws Exception {
        
        when(userRepository.save(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)))
            .andExpect(status().isCreated())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(4))  
            .andExpect(jsonPath("$.username").value("4"))  
            .andExpect(jsonPath("$.password").value("4"))
            .andExpect(jsonPath("$.type").value("admin")); 
    }

    @Test
    public void testPut() throws Exception{
        User newUser = new User(); 
        newUser.setId(4);
        newUser.setUsername("u4");
        newUser.setPassword("p4");
        newUser.setType("candidate");
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(newUser);

        mockMvc.perform(put("/users/4")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(newUser)))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(4))  
            .andExpect(jsonPath("$.username").value("u4"))  
            .andExpect(jsonPath("$.password").value("p4"))
            .andExpect(jsonPath("$.type").value("candidate")); 
    }


}