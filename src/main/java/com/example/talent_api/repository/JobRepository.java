package com.example.talent_api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.talent_api.entity.Job;
 
@Repository
public interface JobRepository extends CrudRepository<Job, Integer>{
    public Job findFirstById(Long id);

    // @Query(value = "SELECT * FROM JOB_LISTING WHERE MANAGER_ID = :manager_id", nativeQuery = true)
    public List<Job> findBymanagerID(int managerID);
    
}
