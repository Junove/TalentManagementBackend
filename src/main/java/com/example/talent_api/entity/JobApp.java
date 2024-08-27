package com.example.talent_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "JOB_APPLICATION")
public class JobApp {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    long id;

    @Column(name="CANDIDATE_ID")
    int candidate_id; 

    @Column(name="JOB_ID")
    int job_id; 

    @Column(name="DATE_APPLIED")
    String date_applied;

    @Column(name="COVER_LETTER")
    String cover_letter;

    @Column(name="CUSTOM_RESUME")
    String custom_resume;

    @Column(name="APPLICATION_STATUS")
    String application_status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(int candidate_id) {
        this.candidate_id = candidate_id;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public String getDate_applied() {
        return date_applied;
    }

    public void setDate_applied(String date_applied) {
        this.date_applied = date_applied;
    }

    public String getCover_letter() {
        return cover_letter;
    }

    public void setCover_letter(String cover_letter) {
        this.cover_letter = cover_letter;
    }

    public String getCustom_resume() {
        return custom_resume;
    }

    public void setCustom_resume(String custom_resume) {
        this.custom_resume = custom_resume;
    }

    public String getApplication_status() {
        return application_status;
    }

    public void setApplication_status(String application_status) {
        this.application_status = application_status;
    }

    

    
}
