package com.example.talent_api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class UserController {
    @GetMapping("/users")
    public String getAll() {
        return "All users";
    }

    // Read Operation
    @GetMapping("/users/{id}")
    public String getCandidateById(@PathVariable("id") Long id) {
        return "User with ID: " + id;
    }

    // Create Operation
    @PostMapping("/users")
    public String addCandidate(@RequestBody String candidate) {
        return "User added";
    }

    // Update Operation
    @PutMapping("/users/{id}")
    public String updateCandidate(@PathVariable Long id, @RequestBody String candidate) {
        return "User updated";
    }

    // Delete Operation
    @DeleteMapping("/users/{id}")
    public String deleteCandidate(@PathVariable Long id) {
        return "User deleted";
    }
}