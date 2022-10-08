package com.example.getyourway.controller;

import com.example.getyourway.entities.User;
import com.example.getyourway.exceptions.ResourceNotFoundException;
import com.example.getyourway.repositiories.UserRepo;
import com.example.getyourway.repository.UserRepository;
import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    private UserRepo userRepository;

    @Autowired
    public UserController(UserRepo userRepository){
        this.userRepository = userRepository;
    }
    @CrossOrigin(origins = "${react.url}")
    @GetMapping("/show")
    public ResponseEntity<List<User>> getUser(){
        return ResponseEntity.ok(this.userRepository.findAll());
    }

    @CrossOrigin(origins = "${react.url}")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable(value = "id") int id){
        User user = this.userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("This user does not exist")
        );
        return new ResponseEntity<>(user, HttpStatus.OK );
    }

    //All put/post requests for users
    @CrossOrigin(origins = "${react.url}")
    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        return this.userRepository.save(user);
    }

    @CrossOrigin(origins = "${react.url}")
    @PatchMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User newUser, @PathVariable(value = "id") Integer id){
        System.out.println(newUser.getFirstName());
        System.out.println(newUser.getLastName());
        System.out.println(newUser.getEmailAddress());

        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) return null;
        User existingUser = user.get();
        existingUser.setFirstName(newUser.getFirstName());
        existingUser.setLastName(newUser.getLastName());
        existingUser.setEmailAddress(newUser.getEmailAddress());
        userRepository.save(existingUser);
        return new ResponseEntity<>(existingUser, HttpStatus.OK);

    }
    @CrossOrigin(origins = "${react.url}")
    @DeleteMapping("user/{id}")
    public ResponseEntity<Void> removeUser(@PathVariable(value = "id") int id){
        User user = this.userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found")
        );
        this.userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}
