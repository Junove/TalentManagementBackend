package com.example.talent_api.controllers;

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

import com.example.talent_api.entity.JobApp;
import com.example.talent_api.repository.JobAppRepository;

@CrossOrigin
@RestController
public class JobAppsController {
	
    @Autowired
    private JobAppRepository jobappRepository;
    
    // @GetMapping("/jobapps")
	// public Iterable<JobApp> getAll() {
		
	// }
	@GetMapping("/jobapps")
	public String getAll(){
		return "list of job applications";
	}

	// @GetMapping("/jobapps/{id}")
	// public Optional<Job> getJobAppById(@PathVariable("id") long id) {

	// }
	@GetMapping("/jobapps/{id}")
	public String getJobAppById(@PathVariable("id") long id){
		return "id specific job";
	}

	// @GetMapping("/jobapps/managerspec/{manager_id}")
	// public Optional<Job> getJobAppsByManagerId(@PathVariable("manager_Id") String id) {
	// }
	@GetMapping("/jobapps/managerspec/{manager_id}")
	public String getJobAppsByManagerId(@PathVariable("manager_id") long id){
		return "managerid specific job applications";
	}

	// @GetMapping("/jobapps/jobspec/{job_id}")
	// public Optional<Job> getJobAppsByManagerId(@PathVariable("manager_Id") String id) {
	// }
	@GetMapping("/jobapps/jobspec/{job_id}")
	public String getJobAppsByJobId(@PathVariable("job_id") long id){
		return "jobid specific job applications";
	}
	

	// @PostMapping("/jobapps")
	// public ResponseEntity<?> addJobApp(@RequestBody JobApp newJob, UriComponentsBuilder uri) {

	// }
	@PostMapping("/jobapps")
	public String addJob(@RequestBody JobApp newJob){
		return "come here to add/post a job app";
	}

	// @PutMapping("/jobapps/{id}")
	// public ResponseEntity<?> putJobApp(@RequestBody JobApp newJob,
	// 		@PathVariable("id") long id){
		
	// }
	@PutMapping("/jobapps/{id}")
	public String putJob(@RequestBody JobApp newJob){
		return "putting a job";
	}

	//@DeleteMapping("/jobapps/{id}")
	// public ResponseEntity<?> deleteJobAppById(@PathVariable("id") long id) {

	// }
	@DeleteMapping("/jobapps/{id}")
	public String deleteJobAppByID(@PathVariable("id") long id){
		return "come here to delete job app";
	}

}
