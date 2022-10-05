package com.example.getyourway.controller;

import com.example.getyourway.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //String encodedPgit assword = passwordEncoder.encode(user.getPassword());
        //user.setPassword(encodedPassword);

        //userRepo.save(user);

        return "register_success";
    }
}
