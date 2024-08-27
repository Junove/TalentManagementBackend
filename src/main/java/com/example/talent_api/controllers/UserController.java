package com.example.talent_api.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.talent_api.entity.User;
import com.example.talent_api.repository.UserRepository;


@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = (List<User>) userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Read Operation
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
            .map(user -> new ResponseEntity<>(user, HttpStatus.OK))  // User found
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));  // User not found
    }
    
    // Create Operation
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Update Operation
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        // Check if the user exists
        return userRepository.findById(id)
            .map(existingUser -> {
                existingUser.setUsername(updatedUser.getUsername()); 
                existingUser.setPassword(updatedUser.getPassword()); 
                
                User savedUser = userRepository.save(existingUser);
                return new ResponseEntity<>(savedUser, HttpStatus.OK);
            })
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); // Return 404 if user not found
    }

    // Delete Operation
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        // Check if the user exists
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}