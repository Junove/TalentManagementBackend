package com.example.talent_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.talent_api.entity.Candidate;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Long> {
    public Candidate findFirstByEmail(String email);

    public Candidate findFirstById(Long id);
}