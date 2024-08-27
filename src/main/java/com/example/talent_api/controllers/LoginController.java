package com.example.talent_api.controllers;
import com.example.talent_api.entity.Credentials;
import com.example.talent_api.entity.User;
import com.example.talent_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LoginController {

	@Autowired
	UserRepository userRepository;
	
    @PostMapping("/login")
    public ResponseEntity<User> create(@RequestBody Credentials credentials) {
    	User user = userRepository.findByUsername(credentials.getUsername());
    	if(user == null) {
    		return ResponseEntity.status(401).body(null);
    	}
    	if(user.getPassword().equalsIgnoreCase(credentials.getPassword() )) {
    		return ResponseEntity.status(200).body(user);
    	}else {
    		return ResponseEntity.status(401).body(null);
    	}
    }	

}
