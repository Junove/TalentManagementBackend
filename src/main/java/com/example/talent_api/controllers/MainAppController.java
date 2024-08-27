package com.example.talent_api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class MainAppController {
    @PostMapping("/registration")
    public String registerUser(@RequestBody String user) {
        return "User registered";
    }

    // @PostMapping("/login")
    // public String loginUser(@RequestBody String user) {
    //     return "User logged in";
    // }
}