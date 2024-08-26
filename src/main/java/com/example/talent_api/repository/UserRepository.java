package com.example.talent_api.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.talent_api.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    public Optional<User> findUserById(long id);
    
} 