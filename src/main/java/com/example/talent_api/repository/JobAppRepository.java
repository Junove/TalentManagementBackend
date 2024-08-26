package com.example.talent_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.talent_api.entity.JobApp;

@Repository
public interface JobAppRepository extends CrudRepository<JobApp, Long> {
    
}