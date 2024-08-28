package com.example.talent_api.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.talent_api.entity.Candidate;
import com.example.talent_api.entity.User;
import com.example.talent_api.repository.CandidateRepository;
import com.example.talent_api.repository.UserRepository;
import com.example.talent_api.service.FileStorageService;

@CrossOrigin
@RestController
@RequestMapping("/candidates")
public class CandidateController {

   @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping
    public ResponseEntity<Candidate> addCandidate(
            @RequestParam("fullName") String fullName,
            @RequestParam("email") String email,
            @RequestParam("address") String address,
            @RequestParam("phone") String phone,
            @RequestParam("userId") Long userId,
            @RequestParam("resume") MultipartFile resumeFile) {

        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            String resumePath = fileStorageService.storeFile(resumeFile);

            Candidate candidate = new Candidate();
            candidate.setFullName(fullName);
            candidate.setEmail(email);
            candidate.setAddress(address);
            candidate.setPhone(phone);
            candidate.setResume(resumePath);
            candidate.setUser(userOptional.get());

            Candidate savedCandidate = candidateRepository.save(candidate);

            return new ResponseEntity<>(savedCandidate, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all candidates
    @GetMapping
    public ResponseEntity<List<Candidate>> getAll() {
        List<Candidate> candidates = (List<Candidate>)candidateRepository.findAll();
        return new ResponseEntity<>(candidates, HttpStatus.OK);
    }
    @GetMapping("/userId/{userId}")
    public ResponseEntity<Candidate> getCandidateByUserId(@PathVariable Long userId) {
        Candidate candidate = candidateRepository.findByuserId(userId);
        if (candidate != null) {
            return new ResponseEntity<>(candidate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Get candidate by ID
    @GetMapping("/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable("id") long id) {
        Optional<Candidate> candidate = candidateRepository.findById(id);
        return candidate.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    // Update an existing candidate
    @PutMapping("/{id}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable("id") long id, @RequestBody Candidate updatedCandidate) {
        Optional<Candidate> candidate = candidateRepository.findById(id);
        if (candidate.isPresent()) {
            updatedCandidate.setId(id); // Ensure the ID remains the same
            Candidate savedCandidate = candidateRepository.save(updatedCandidate);
            return new ResponseEntity<>(savedCandidate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a candidate
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidateById(@PathVariable("id") long id) {
        if (candidateRepository.existsById(id)) {
            candidateRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Upload PDF and store file path in resume field
    @PostMapping("/{id}/uploadPdf")
    public ResponseEntity<String> uploadPdf(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) {
        if (!file.getContentType().equals("application/pdf")) {
            return new ResponseEntity<>("Only PDF files are allowed.", HttpStatus.BAD_REQUEST);
        }

        Optional<Candidate> candidateOptional = candidateRepository.findById(id);
        if (candidateOptional.isPresent()) {
            Candidate candidate = candidateOptional.get();

            try {
                // Use the service to store the file and get the file path
                String filePath = fileStorageService.storeFile(file);

                // Update the candidate's resume field with the file path
                candidate.setResume(filePath);
                candidateRepository.save(candidate);

                return new ResponseEntity<>("File uploaded successfully: " + filePath, HttpStatus.OK);
            } catch (IOException e) {
                return new ResponseEntity<>("File upload failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>("Candidate not found.", HttpStatus.NOT_FOUND);
        }
    }
}
