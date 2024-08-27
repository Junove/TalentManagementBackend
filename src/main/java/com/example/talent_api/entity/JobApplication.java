package com.example.talent_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(name="job_application")
public class JobApplication {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="JOB_ID")
    private Long job_id;

    @Column(name="CANDIDATE_ID")
    private Long candidate_id;

    @Column(name="DATE_LISTED")
    private String date_listed;

    @Column(name="COVER_LETTER")
    private String cover_letter;

    @Column(name="RESUME")
    private String resume;

    @Column(name="APPLICATION_STATUS")
    private String application_status;

    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public Long getJobId(){
        return this.job_id;
    }
    public void setJobId(Long job_id){
        this.job_id=job_id;
    }
    public Long getCandidateId(){
        return this.candidate_id;
    }
    public void setCandidateId(Long candidate_id){
        this.candidate_id=candidate_id;
    }
    public String getDateListed(){
        return this.date_listed;
    }
    public void setDateListed(String dateListed){
        this.date_listed=dateListed;
    }
    public String getCoverLetter(){
        return this.cover_letter;
    }
    public void setCoverLetter(String coverLetter){
        this.cover_letter=coverLetter;
    }
    public String getResume(){
        return this.resume;
    }
    public void setResume(String resume){
        this.resume=resume;
    }
    public String getApplicationStatus(){
        return this.application_status;
    }
    public void setApplicationStatus(String application_status){
        this.application_status=application_status;
    }
    

    
}
