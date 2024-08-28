package com.example.talent_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.talent_api.entity.Candidate;
import com.example.talent_api.entity.HiringManager;
import com.example.talent_api.repository.HiringManagerRepository;

@CrossOrigin
@RestController
@RequestMapping("/managers")
public class HiringManagerController {

    @Autowired
    private HiringManagerRepository hiringManagerRepository;

    @GetMapping
    public ResponseEntity<List<HiringManager>> getAllHiringManagers() {
        return new ResponseEntity<>((List<HiringManager>) hiringManagerRepository.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<HiringManager> getHiringManagerById(@PathVariable Long id) {
        HiringManager hiringManager = hiringManagerRepository.findById(id).orElse(null);
        if (hiringManager != null) {
            return new ResponseEntity<>(hiringManager, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<HiringManager> getHiringManagerByUserId(@PathVariable Long userId) {
        HiringManager hiringManager = hiringManagerRepository.findByuserId(userId);
        if (hiringManager != null) {
            return new ResponseEntity<>(hiringManager, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<HiringManager> createHiringManager(@RequestBody HiringManager hiringManager) {
        return new ResponseEntity<>(hiringManagerRepository.save(hiringManager), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HiringManager> updateHiringManager(@PathVariable Long id, @RequestBody HiringManager hiringManagerDetails) {
        HiringManager hiringManager = hiringManagerRepository.findById(id).orElse(null);
        if (hiringManager != null) {
            hiringManager.setName(hiringManagerDetails.getName());
            hiringManager.setEmail(hiringManagerDetails.getEmail());
            hiringManager.setDepartment(hiringManagerDetails.getDepartment());
            hiringManager.setPhone(hiringManagerDetails.getPhone());
            return new ResponseEntity<>(hiringManagerRepository.save(hiringManager), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHiringManager(@PathVariable Long id) {
        if (hiringManagerRepository.existsById(id)) {
            hiringManagerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}