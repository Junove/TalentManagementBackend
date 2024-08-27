package com.example.talent_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.talent_api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	  // This method will automatically be translated to a JPQL query
	  User findByUsername(String username);
}
