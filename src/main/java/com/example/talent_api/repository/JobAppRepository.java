package com.example.talent_api.repository;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;

import com.example.talent_api.entity.JobApp;

@Repository
public interface JobAppRepository extends CrudRepository<JobApp, Long> {
    public List<JobApp> findByjobId(Long jobId);

    // @Query("SELECT jobapp from job_application jobapp" + "JOIN jobapp.job_id jl" +  "JOIN jobapp.candidate_id c" + "WHERE jl.hiring_manager.id = :manager_id")
    // public List<JobApp> findByManagerId(Long manager_id);
}