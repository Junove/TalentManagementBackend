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

    @Column(name="Manager_ID")
    int managerID; 

    @Column(name="department")
    String department;

    @Column(name="listing_title")
    String listing_title;

    //Format is YYYY-MM-DD HH:MM:S
    @Column(name="DATE_LISTED")
    String date_listed;

    //Format is YYYY-MM-DD HH:MM:S
    @Column(name="DATE_CLOSED")
    String date_closed;

    @Column(name="job_title")
    String job_title;

    @Column(name="JOB_DESCRIPTION")
    String job_description;

    @Column(name="additional_information")
    String additional_information;

    //Values are "Open" or "Closed"
    @Column(name="LISTING_STATUS")
    String listing_status;


    public Job(){
        
    }

    public Job(String department, String job_title, String job_description, String additional_information){
        this.department = department;
        this.job_title = job_title;
        this.job_description = job_description;
        this.additional_information = additional_information;
    }

    public Job(String department, String job_title, String job_description, String additional_information, String listing_status){
        this.department = department;
        this.job_title = job_title;
        this.job_description = job_description;
        this.additional_information = additional_information;
        this.listing_status = listing_status;
    }



    public Job(int managerID, String department, String listing_title, String date_listed, String date_closed, String job_title, String job_description, String additional_information, String listing_status){
        this.managerID = managerID;
        this.department = department;
        this.listing_title = listing_title;
        this.date_listed = date_listed;
        this.date_closed = date_closed;
        this.job_title = job_title;
        this.job_description = job_description;
        this.additional_information = additional_information;
        this.listing_status = listing_status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getManager_id() {
        return managerID;
    }

    public void setManager_id(int managerID) {
        this.managerID = managerID;
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

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
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
