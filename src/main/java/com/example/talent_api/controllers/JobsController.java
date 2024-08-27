package com.example.talent_api.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.talent_api.entity.Job;
import com.example.talent_api.repository.JobRepository;


@RestController
@RequestMapping("/jobs")
@CrossOrigin(origins = "http://localhost:3000")
public class JobsController {
	@Autowired
	JobRepository repo;

	@GetMapping
	public Iterable<Job> getAll() {
		return repo.findAll();
		
	}
	// @GetMapping("/{id}")
	// public Optional<Job> getJobById(@PathVariable("id") long id) {

	// }
	@GetMapping("/{id}")
	public String getJobById(@PathVariable("id") long id){
		return "id specific job";
	}

	// @GetMapping("/managerspec/{manager_id}")
	// public Optional<Job> getJobByManagerId(@PathVariable("manager_Id") String id) {
	// }
	@GetMapping("/managerspec/{manager_id}")
	public String getJobByManagerId(@PathVariable("manager_id") long id){
		return "managerid specific job";
	}
	

	@PostMapping
	public ResponseEntity<?> addJob(@RequestBody Job newJob, UriComponentsBuilder uri) {

		
		repo.save(newJob);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(newJob.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();


		return response;

	}
	

	// @PutMapping("/{id}")
	// public ResponseEntity<?> putJob(@RequestBody Job newJob,
	// 		@PathVariable("id") long id){
		
	// }
	@PutMapping("/{id}")
	public String putJob(@RequestBody Job newJob){
		return "putting a job";
	}

	//@DeleteMapping("/{id}")
	// public ResponseEntity<?> deleteJobById(@PathVariable("id") long id) {

	// }
	@DeleteMapping("/{id}")
	public String deleteJobByID(@PathVariable("id") long id){
		return "come here to delete job";
	}

}
