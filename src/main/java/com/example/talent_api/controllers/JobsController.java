package com.example.talent_api.controllers;

import java.net.URI;

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
    public Iterable<Job> getJobByManagerId(@PathVariable("manager_id") int managerId) {
        Iterable<Job> jobs = repo.findByManagerId(managerId);
        return (jobs);
    }



	@PostMapping
	public ResponseEntity<?> addJob(@RequestBody Job newJob, UriComponentsBuilder uri) {

		// Hand logic to handle verify response

		repo.save(newJob);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newJob.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();

		return response;

	}

@PutMapping("/{id}")
public ResponseEntity<?> updateJob(@RequestBody Job updatedJob, @PathVariable("id") Long id) {
    Job existingJob = repo.findById(id);

    if (existingJob != null) {
        existingJob.setDepartment(updatedJob.getDepartment());
        existingJob.setJob_title(updatedJob.getJob_title());
        existingJob.setJob_description(updatedJob.getJob_description());
        existingJob.setAdditional_information(updatedJob.getAdditional_information());
        existingJob.setListing_status(updatedJob.getListing_status());

        Job savedJob = repo.save(existingJob);

        return ResponseEntity.ok(savedJob);
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
