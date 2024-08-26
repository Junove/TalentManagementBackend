package com.example.talent_api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.talent_api.entity.Candidate;
import com.example.talent_api.repository.CandidateRepository;

@CrossOrigin
@RestController
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;

    @GetMapping("/candidates")
    public Iterable<Candidate> getAll() {
        return candidateRepository.findAll();
    }

    // Read Operation
    @GetMapping("/candidates/{id}")
    public Optional<Candidate> getCandidateById(@PathVariable("id") Long id) {
        return candidateRepository.findById(id);
    }

    // Create Operation
    @PostMapping("/candidates")
    public Candidate addCandidate(@RequestBody Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    // Update Operation
    @PutMapping("/candidates/{id}")
    public Candidate updateCandidate(@PathVariable Long id, @RequestBody Candidate candidate) {
        Optional<Candidate> candidateOptional = candidateRepository.findById(id);
        if (candidateOptional.isPresent()) {
            Candidate candidateToUpdate = candidateOptional.get();
            candidateToUpdate.setUser(candidate.getUser());
            candidateToUpdate.setFullName(candidate.getFullName());
            candidateToUpdate.setEmail(candidate.getEmail());
            candidateToUpdate.setAddress(candidate.getAddress());
            candidateToUpdate.setPhone(candidate.getPhone());
            candidateToUpdate.setResume(candidate.getResume());

            return candidateRepository.save(candidateToUpdate);
        } else {
            return null;
        }
    }

    // Delete Operation
    @DeleteMapping("/candidates/{id}")
    public void deleteCandidate(@PathVariable Long id) {
        candidateRepository.deleteById(id);
    }
}