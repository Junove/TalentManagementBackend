package com.example.talent_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.talent_api.entity.HiringManager;

@Repository
public interface HiringManagerRepository extends CrudRepository<HiringManager, Long> {
    public HiringManager findFirstByEmail(String email);

    public HiringManager findByuserId(Long userId);
}
