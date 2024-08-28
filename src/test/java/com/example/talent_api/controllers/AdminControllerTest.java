package com.example.talent_api.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.AdditionalMatchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.talent_api.entity.Admin;
import com.example.talent_api.entity.User;
import com.example.talent_api.repository.AdminRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(AdminController.class)
public class AdminControllerTest {

    @MockBean
    AdminRepository repo;

    @Autowired
    private MockMvc mockMvc;

    List<Admin> admins = new ArrayList<>();

    @BeforeEach
    void init() {
        User user = new User();
        user.setId(1L);
        user.setUsername("username");
        user.setPassword("password");
        user.setType("candidate");
        
        for (int i = 1; i <= 3; i++) {
            Admin admin = new Admin();
            admin.setId(Long.valueOf(i));
            admin.setName(i + "name");
            admin.setEmail(i + "johndoe@gmail.com");
            admin.setUser(user);
            admins.add(admin);
        }
    }

    @Test
    void getAllAdmins() throws Exception {
        when(repo.findAll()).thenReturn(admins);

        mockMvc.perform(get("/admins"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").exists())
        .andExpect(jsonPath("[0]").exists())
        .andExpect(jsonPath("[2]").exists());
    }

    @Test
    void getAdminById() throws Exception {
        mockMvc.perform(get("/admins/ "))
        .andExpect(status().is4xxClientError());

        when(repo.findById(1L)).thenReturn(Optional.of(admins.get(0)));

        mockMvc.perform(get("/admins/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("id").value(1));
    }

    @Test
    void createAdmin() throws Exception {
        mockMvc.perform(post("/admins"))
        .andExpect(status().is4xxClientError());

        User user = new User();
        user.setId(1L);
        user.setUsername("username");
        user.setPassword("password");
        user.setType("candidate");

        Admin admin = new Admin();
        admin.setId(10L);
        admin.setName("name");
        admin.setEmail("johndoe@gmail.com");
        admin.setUser(user);

        when(repo.save(any(Admin.class))).thenReturn(admin);

        mockMvc.perform(post("/admins")
        .contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(admin)))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$").exists());
    }

    @Test
    void updateAdmin() throws Exception {
        when(repo.findById(anyLong())).thenReturn(Optional.of(admins.get(0)));
        admins.get(0).setId(10L);
        when(repo.save(any(Admin.class))).thenReturn(admins.get(0)); //new id set

        mockMvc.perform(put("/admins/ "))
        .andDo(print())
        .andExpect(status().is4xxClientError());

        mockMvc.perform(put("/admins/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(admins.get(0))))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").exists())
        .andExpect(jsonPath("$.id").value(10L));
    }

    @Test
    void deleteAdmin() throws Exception {
        when(repo.existsById(0L)).thenReturn(false);
        when(repo.existsById(not(eq(0L)))).thenReturn(true);
        doNothing().when(repo).delete(any(Admin.class));

        mockMvc.perform(delete("/admins/ ")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isBadRequest());

        mockMvc.perform(delete("/admins/0")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isNotFound());

        mockMvc.perform(delete("/admins/1")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isNoContent());
    }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
    //     if (adminRepository.existsById(id)) {
    //         adminRepository.deleteById(id);
    //         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //     } else {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }
}
