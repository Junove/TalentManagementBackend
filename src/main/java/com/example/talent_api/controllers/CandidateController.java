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
public class CandidateController {
    @GetMapping("/candidates")
    public String getAll() {
        return "All Candidates";
    }

    // Read Operation
    @GetMapping("/candidates/{id}")
    public String getCandidateById(@PathVariable("id") Long id) {
        return "Candidate with ID: " + id;
    }

    // Create Operation
    @PostMapping("/candidates")
    public String addCandidate(@RequestBody String candidate) {
        return "Candidate added";
    }

    // Update Operation
    @PutMapping("/candidates/{id}")
    public String updateCandidate(@PathVariable Long id, @RequestBody String candidate) {
        return "Candidate updated";
    }

    // Delete Operation
    @DeleteMapping("/candidates/{id}")
    public String deleteCandidate(@PathVariable Long id) {
        return "Candidate deleted";
    }
}