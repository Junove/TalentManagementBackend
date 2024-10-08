package com.example.talent_api.controllers;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import com.example.talent_api.entity.Job;
import com.example.talent_api.repository.JobRepository;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;



@CrossOrigin
@RestController
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
		Job tempJob = repo.findFirstById(id);
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

		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = currentDate.format(formatter);

		newJob.setDate_listed(formattedDate);
		newJob.setListing_status("Open");

		repo.save(newJob);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newJob.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();

		return new ResponseEntity<>(newJob, HttpStatus.CREATED);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Job> updateJob(@RequestBody Job updatedJob, @PathVariable("id") Long id) {
        Job existingJob = repo.findFirstById(id);
        if (existingJob != null) {
            updatedJob.setId(id); // Ensure the ID remains the same
            Job savedJob = repo.save(updatedJob);
			return new ResponseEntity<>(savedJob, HttpStatus.OK);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteJobById(@PathVariable("id") Long id) {
		Job deleteJob = repo.findFirstById(id);
		if (deleteJob != null) {
			repo.delete(deleteJob);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
