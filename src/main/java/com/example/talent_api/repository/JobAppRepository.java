package com.example.talent_api.repository;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.example.talent_api.entity.JobApp;

@Repository
public interface JobAppRepository extends CrudRepository<JobApp, Long> {
    public List<JobApp> findByjobId(Long jobId);

    public List<JobApp> findAllBycandidateId(Long candidateId);

    @Query(value="SELECT ja.id, ja.candidate_id, ja.cover_letter, ja.custom_resume, c.full_name AS candidate_name, jl.listing_title, jl.id AS job_id, ja.date_applied, ja.application_status FROM job_application ja JOIN job_listing jl ON ja.job_id = jl.id JOIN candidate c ON ja.candidate_id = c.id WHERE jl.manager_id = :managerId;", nativeQuery = true)
    public List<JobApp> findAllByHiringManagerId(@Param("managerId") Integer manager_id);
}