package com.example.talent_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.talent_api.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    public User findUserById(long id);

    public User findByUsername(String username);
    
}

