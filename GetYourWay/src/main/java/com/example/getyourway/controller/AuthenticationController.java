package com.example.getyourway.controller;

import com.example.getyourway.DTOs.LoginRequest;
import com.example.getyourway.DTOs.Password;
import com.example.getyourway.entities.User;
import com.example.getyourway.exceptions.PasswordsDontMatchException;
import com.example.getyourway.exceptions.UserDetailsException;
import com.example.getyourway.repositiories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
public class AuthenticationController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    SubscriptionController subController;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @CrossOrigin(origins = "${react.url}")
    @PostMapping("/process_register")
    public ResponseEntity<String> registerNewUser(@RequestBody User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Optional<User> exists = userRepo.findUserByEmailAddress(user.getEmailAddress());
        System.out.println(exists.isPresent());
        if(exists.isPresent()) throw new UserDetailsException("User already exists! Log in or choose a different email!");

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        try{
            userRepo.save(user);
        } catch(DataAccessException e){
            throw new UserDetailsException("Unable to process user. Check details are valid and try again later!");
        }
        return new ResponseEntity<>(String.valueOf(user.getId()), HttpStatus.OK);
    }

    @CrossOrigin(origins = "${react.url}")
    @PostMapping("/userLogin")
    public ResponseEntity<String> userLogin(@RequestBody LoginRequest request){

        User user = userRepo.findByEmailAddress(request.getEmail());

        if(user == null || !user.hasSubscription()) throw new UsernameNotFoundException("No account found. Please register with us!");

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) throw new PasswordsDontMatchException();

        return new ResponseEntity<>(String.valueOf(user.getId()),HttpStatus.OK);
    }

    @CrossOrigin(origins = "${react.url}")
    @PatchMapping("/updatepassword/{id}")
    public ResponseEntity<Object> updatePassword(@RequestBody Password password, @PathVariable(value = "id") int id){
        Optional<User> user = userRepo.findById(id);
        System.out.println(password.getPassword());
        if(!user.isPresent())return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        User updatedUser = user.get();
        updatedUser.setPassword(passwordEncoder.encode(password.getPassword()));
        userRepo.save(updatedUser);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    //If this returns a 200 then the user is logged in
    @CrossOrigin(origins = "${react.url}")
    @GetMapping("/is_logged_in")
    public ResponseEntity<Object> amILoggedIn() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
