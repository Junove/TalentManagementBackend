package com.example.talent_api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.talent_api.entity.Job;
 
@Repository
public interface JobRepository extends CrudRepository<Job, Integer>{
    Job findById(Long id);

    @Query(value = "SELECT * FROM JOB_LISTING WHERE MANAGER_ID = :manager_id", nativeQuery = true)
    Iterable<Job> findByManagerId(@Param("manager_id") int managerId);
    
}
