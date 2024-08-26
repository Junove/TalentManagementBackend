package com.example.talent_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.talent_api.entity.Job;
import com.example.talent_api.repository.JobRepository;


@CrossOrigin
@RestController
public class JobsController {
	
	@Autowired
	private JobRepository jobRepository;

	// @GetMapping("/jobs")
	// public Iterable<Job> getAll() {
		
	// }
	@GetMapping("/jobs")
	public String getAll(){
		return "list of jobs";
	}

	// @GetMapping("/jobs/{id}")
	// public Optional<Job> getJobById(@PathVariable("id") long id) {

	// }
	@GetMapping("/jobs/{id}")
	public String getJobById(@PathVariable("id") long id){
		return "id specific job";
	}

	// @GetMapping("jobs/managerspec/{manager_id}")
	// public Optional<Job> getJobByManagerId(@PathVariable("manager_Id") String id) {
	// }
	@GetMapping("/jobs/managerspec/{manager_id}")
	public String getJobByManagerId(@PathVariable("manager_id") long id){
		return "managerid specific job";
	}
	

	// @PostMapping
	// public ResponseEntity<?> addJob(@RequestBody Job newJob, UriComponentsBuilder uri) {

	// }
	@PostMapping("/jobs")
	public String addJob(@RequestBody Job newJob){
		return "come here to add/post a job";
	}

	// @PutMapping("/jobs/{id}")
	// public ResponseEntity<?> putJob(@RequestBody Job newJob,
	// 		@PathVariable("id") long id){
		
	// }
	@PutMapping("/jobs/{id}")
	public String putJob(@RequestBody Job newJob){
		return "putting a job";
	}

	//@DeleteMapping("/jobs/{id}")
	// public ResponseEntity<?> deleteJobById(@PathVariable("id") long id) {

	// }
	@DeleteMapping("/jobs/{id}")
	public String deleteJobByID(@PathVariable("id") long id){
		return "come here to delete job";
	}

}
