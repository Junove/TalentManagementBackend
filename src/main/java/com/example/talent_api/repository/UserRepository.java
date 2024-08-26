package com.example.talent_api.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.talent_api.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

    // This method will automatically be translated to a JPQL query
	  User findByUsername(String username);
} 