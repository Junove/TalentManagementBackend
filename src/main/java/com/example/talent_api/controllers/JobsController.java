package main.java.com.example.talent_api.controllers;

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


import jakarta.annotation.PostConstruct;

import com.example.talent_api.entity.Job;


@RestController
@RequestMapping("/jobs")
public class JobsController {
	// @GetMapping
	// public Iterable<Job> getAll() {
		
	// }
	@GetMapping
	public String getAll(){
		return "list of users";
	}

	// @GetMapping("/{id}")
	// public Optional<Job> getJobById(@PathVariable("id") long id) {

	// }
	@GetMapping("/{id}")
	public String getJobById(long id){
		return "id specific job";
	}

	// @GetMapping("/{manager_id}")
	// public Optional<Job> getJobByManagerId(@PathVariable("managerId") String id) {
	// }
	@GetMapping("/{manager_id}")
	public String getJobByManagerId(long id){
		return "managerid specific job";
	}
	

	// @PostMapping
	// public ResponseEntity<?> addJob(@RequestBody Job newJob, UriComponentsBuilder uri) {

	// }
	@PostMapping
	public String addJob(Job newJob){
		return "come here to add/post a job";
	}

	// @PutMapping("/{id}")
	// public ResponseEntity<?> putJob(@RequestBody Job newJob,
	// 		@PathVariable("id") long id){
		
	// }
	@PutMapping("/{id}")
	public String putJob(Job newJob){
		return "putting a job";
	}

	//@DeleteMapping("/{id}")
	// public ResponseEntity<?> deleteJobById(@PathVariable("id") long id) {

	// }
	@DeleteMapping("/{id}")
	public String deleteJobByID(long id){
		return "come here to delete job";
	}

}
