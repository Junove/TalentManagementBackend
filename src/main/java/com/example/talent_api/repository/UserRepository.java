package com.example.talent_api.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.talent_api.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{

    
} 