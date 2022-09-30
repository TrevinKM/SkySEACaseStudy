package com.example.getyourway.controller;

import com.example.getyourway.entities.User;
import com.example.getyourway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //All get requests for users

    @GetMapping("/user/show")
    public ResponseEntity<List<User>> getUser(){
        return ResponseEntity.ok(this.userRepository.findAll());
    }
}
