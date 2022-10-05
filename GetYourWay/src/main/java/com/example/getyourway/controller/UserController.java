package com.example.getyourway.controller;

import com.example.getyourway.entities.User;
import com.example.getyourway.exceptions.ResourceNotFoundException;
import com.example.getyourway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/show")
    public ResponseEntity<List<User>> getUser(){
        return ResponseEntity.ok(this.userRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable(value = "id") Long id){
        User user = this.userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("This user does not exist")
        );
        return ResponseEntity.ok().body(user);
    }

    //All put/post requests for users

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        return this.userRepository.save(user);
    }

    /*
    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User userN, @PathVariable(value = "id") Long id){
        return this.userRepository.findById(id).map(user -> {

        });
    }
    */
    @DeleteMapping("user/{id}")
    public ResponseEntity<Void> removeUser(@PathVariable(value = "id") Long id){
        User user = this.userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found")
        );
        this.userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}
