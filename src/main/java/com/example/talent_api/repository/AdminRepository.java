package com.example.talent_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.talent_api.entity.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
    public Admin findFirstByEmail(String email);
}
