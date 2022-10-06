package com.example.getyourway.controller;

import com.example.getyourway.DTOs.LoginRequest;
import com.example.getyourway.DTOs.Response;
import com.example.getyourway.entities.Subscription;
import com.example.getyourway.entities.User;
import com.example.getyourway.repositiories.UserRepo;
import com.stripe.exception.StripeException;
import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
public class AuthenticationController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    SubscriptionController subController;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/process_register")
    public ResponseEntity<String> registerNewUser(@RequestBody User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepo.save(user);
        return new ResponseEntity<>(String.valueOf(user.getId()), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/user_login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request){

        User user = userRepo.findByEmailAddress(request.getEmail());
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        boolean matches = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if(matches) return new ResponseEntity<>(String.valueOf(user.getId()),HttpStatus.OK);

        return new ResponseEntity<>("-1", HttpStatus.BAD_REQUEST);
    }


    //If this returns a 200 then the user is logged in
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/is_logged_in")
    public ResponseEntity<Object> amILoggedIn() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
