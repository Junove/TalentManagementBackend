package com.example.talent_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "job_listing")
public class Job {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    long id;

    @Column(name="manager_id")
    int manager_id; 

    @Column(name="department")
    String department;

    @Column(name="listing_title")
    String listing_title;

    @Column(name="date_listed")
    String date_listed;

    @Column(name="date_closed")
    String date_closed;

    @Column(name="job_title")
    String job_title;

    @Column(name="job_description")
    String job_decription;

    @Column(name="additional_information")
    String additional_information;

    @Column(name="listing_status")
    String listing_status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getListing_title() {
        return listing_title;
    }

    public void setListing_title(String listing_title) {
        this.listing_title = listing_title;
    }

    public String getDate_listed() {
        return date_listed;
    }

    public void setDate_listed(String date_listed) {
        this.date_listed = date_listed;
    }

    public String getDate_closed() {
        return date_closed;
    }

    public void setDate_closed(String date_closed) {
        this.date_closed = date_closed;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getJob_decription() {
        return job_decription;
    }

    public void setJob_decription(String job_decription) {
        this.job_decription = job_decription;
    }

    public String getAdditional_information() {
        return additional_information;
    }

    public void setAdditional_information(String additional_information) {
        this.additional_information = additional_information;
    }

    public String getListing_status() {
        return listing_status;
    }

    public void setListing_status(String listing_status) {
        this.listing_status = listing_status;
    }

    
}
