package com.example.talent_api.controllers;

import java.net.URI;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.apple.eawt.Application;
import com.webage.Customers.Customer;
import com.webage.repository.CustomersRepository;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/applications")
public class JobApplicationsAPI {
	@GetMapping
	public Iterable<Application> getAll() {
	}

	@GetMapping("/{id}")
	public Optional<Application> getApplicaitonById(@PathVariable("id") long id) {

	}

	@GetMapping("/findbyManager/{managerId}")
	public Optional<Application> getApplicationByManager(@PathVariable("managerId") String id) {
	}

	@GetMapping("/findbyJobID/{jobId}")
	public Optional<Application> getApplicationByManager(@PathVariable("JobId") String id) {
	}

	@PostMapping
	public ResponseEntity<?> addApplication(@RequestBody Application newApplication, UriComponentsBuilder uri) {

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> putApplication(@RequestBody Application newApplication,
			@PathVariable("id") long id){

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteApplicatoinById(@PathVariable("id") long id) {

	}

}
