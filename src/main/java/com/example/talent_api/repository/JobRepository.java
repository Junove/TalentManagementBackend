package com.example.talent_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.talent_api.entity.Job;
 
@Repository
public interface JobRepository extends CrudRepository<Job, Integer>{
    
}
