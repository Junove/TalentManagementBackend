package com.example.talent_api.controllers;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.talent_api.service.FileStorageService;

import java.util.List;
import java.util.Optional;

import com.example.talent_api.entity.Candidate;
import com.example.talent_api.entity.Job;
import com.example.talent_api.entity.JobApp;
import com.example.talent_api.entity.User;
import com.example.talent_api.repository.JobAppRepository;

@CrossOrigin
@RestController
public class JobAppsController {
	
    @Autowired
    private JobAppRepository jobAppRepository;

	@Autowired
    private FileStorageService fileStorageService;
    
    @GetMapping("/jobapps")
	public ResponseEntity<List<JobApp>> getAll() {
		List<JobApp> jobApps = (List<JobApp>) jobAppRepository.findAll();
        return new ResponseEntity<>(jobApps, HttpStatus.OK);
	}

	@GetMapping("/jobapps/{id}")
	public ResponseEntity<JobApp> getJobAppById(@PathVariable("id") Long id) {
		return jobAppRepository.findById(id)
            .map(jobApp -> new ResponseEntity<>(jobApp, HttpStatus.OK))  
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));  
	}

	@GetMapping("/jobapps/candidatespec/{candidate_id}")
	public ResponseEntity<List<JobApp>> getJobAppsByCandidateId(@PathVariable("candidate_id") Long id) {
		List<JobApp> targetApps = (List<JobApp>) jobAppRepository.findAllBycandidateId(id);
        return new ResponseEntity<>(targetApps, HttpStatus.OK);	
	}
	
	@GetMapping("/jobapps/managerspec/{manager_id}")
	public ResponseEntity<List<JobApp>> getJobAppsByManagerId(@PathVariable("manager_id") Integer id) {
		List<JobApp> targetApps = (List<JobApp>) jobAppRepository.findAllByHiringManagerId(id);
        return new ResponseEntity<>(targetApps, HttpStatus.OK);	
	}


	@GetMapping("/jobapps/jobspec/{job_id}")
	public ResponseEntity <List<JobApp>> getJobAppByJobId(@PathVariable("job_id") Long id) {
		List<JobApp> targetApps = (List<JobApp>) jobAppRepository.findByjobId(id);
		return new ResponseEntity<>(targetApps, HttpStatus.OK);	
	}

    @PostMapping("/jobapps")
    public ResponseEntity<JobApp> addApplication(
            @RequestParam("cover_letter") MultipartFile coverLetterFile,
            @RequestParam("custom_resume") MultipartFile resumeFile,
            @RequestParam("application_status") String applicationStatus,
            @RequestParam("candidate_id") int candId,
            @RequestParam("job_id") int jobId) {

		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = currentDate.format(formatter);
        
        try {
            String resumePath = fileStorageService.storeFile(resumeFile);
			String coverLetterPath = fileStorageService.storeFile(coverLetterFile);

            JobApp application = new JobApp();
            application.setDate_applied(formattedDate);
			application.setCover_letter(coverLetterPath);
			application.setCustom_resume(resumePath);
			application.setApplication_status(applicationStatus);
			application.setCandidate_id(candId);
			application.setJob_id(jobId);

            JobApp savedApplication = jobAppRepository.save(application);

            return new ResponseEntity<>(savedApplication, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	// @PostMapping("/jobapps")
	// public ResponseEntity<JobApp> addJobApp(@RequestBody JobApp newJobApp) {
	// 	JobApp savedJobApp = jobAppRepository.save(newJobApp);
    //     return new ResponseEntity<>(savedJobApp, HttpStatus.CREATED);
	// }

	@PutMapping("/jobapps/{id}")
	public ResponseEntity<JobApp> putJobApp(@RequestBody JobApp targetApp, @PathVariable("id") Long id){
		return jobAppRepository.findById(id)
            .map(currJobApp -> {
                currJobApp.setCandidate_id(targetApp.getCandidate_id()); 
                currJobApp.setJob_id(targetApp.getJob_id()); 
				currJobApp.setDate_applied(targetApp.getDate_applied());
				currJobApp.setCover_letter(targetApp.getCover_letter());
				currJobApp.setCustom_resume(targetApp.getCustom_resume());
				currJobApp.setApplication_status(targetApp.getApplication_status());
                
                JobApp savedJobApp = jobAppRepository.save(currJobApp);
                return new ResponseEntity<>(savedJobApp, HttpStatus.OK);
            })
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	

	@DeleteMapping("/jobapps/{id}")
	public ResponseEntity<Void> deleteJobAppById(@PathVariable("id") Long id) {
		if (jobAppRepository.existsById(id)) {
            jobAppRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
	

}
