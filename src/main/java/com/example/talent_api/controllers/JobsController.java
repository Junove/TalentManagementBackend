package com.example.talent_api.controllers;

import java.net.URI;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.talent_api.entity.Job;
import com.example.talent_api.repository.JobRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/jobs")
public class JobsController {
	@Autowired
	JobRepository repo;

	@GetMapping
	public Iterable<Job> getAll() {
		return repo.findAll();

	}
	@GetMapping("/{id}")
	public  ResponseEntity <Job> getJobById(@PathVariable("id") long id) {
		Job tempJob = repo.findById(id);
		if(tempJob != null){
			return new ResponseEntity<>(tempJob, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}



	@GetMapping("/managerspec/{manager_id}")
    public List<Job> getJobByManagerId(@PathVariable("manager_id") int managerId) {
        List<Job> jobs = repo.findBymanagerID(managerId);
        return (jobs);
    }



	@PostMapping
	public ResponseEntity<?> addJob(@RequestBody Job newJob, UriComponentsBuilder uri) {

		if(newJob.getAdditional_information() == null || newJob.getJob_description() == null ||
		newJob.getJob_title() == null || newJob.getDepartment() == null || newJob.getManager_id() == 0){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		repo.save(newJob);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newJob.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();

		return response;

	}

	@PutMapping("/{id}")
	public ResponseEntity<Job> updateJob(@RequestBody Job updatedJob, @PathVariable("id") Long id) {

		Job existingJob = repo.findById(id);
		
		if (existingJob != null) {
			if (updatedJob.getDepartment() != null) {
				existingJob.setDepartment(updatedJob.getDepartment());
			}
			if (updatedJob.getJob_title() != null) {
				existingJob.setJob_title(updatedJob.getJob_title());
			}
			if (updatedJob.getJob_description() != null) {
				existingJob.setJob_description(updatedJob.getJob_description());
			}
			if (updatedJob.getAdditional_information() != null) {
				existingJob.setAdditional_information(updatedJob.getAdditional_information());
			}
			if (updatedJob.getListing_status() != null) {
				existingJob.setListing_status(updatedJob.getListing_status());
			}
			if(updatedJob.getListing_title() != null){
				existingJob.setListing_title(updatedJob.getListing_title());
			}
		
			repo.save(existingJob);
			return ResponseEntity.ok(existingJob);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteJobById(@PathVariable("id") Long id) {
		Job deleteJob = repo.findById(id);
		if (deleteJob != null) {
			repo.delete(deleteJob);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
