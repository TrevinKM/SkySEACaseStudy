package com.example.getyourway.controller;

import com.example.getyourway.DTOs.LoginRequest;
import com.example.getyourway.DTOs.Response;
import com.example.getyourway.entities.Subscription;
import com.example.getyourway.entities.User;
import com.example.getyourway.exceptions.PasswordsDontMatchException;
import com.example.getyourway.exceptions.UserDetailsException;
import com.example.getyourway.repositiories.UserRepo;
import com.stripe.exception.StripeException;
import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.security.Provider;
import java.util.Optional;
import java.util.zip.DataFormatException;

@RestController
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

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/userLogin")
    public ResponseEntity<String> userLogin(@RequestBody LoginRequest request){

        User user = userRepo.findByEmailAddress(request.getEmail());

        if(user == null || !user.hasSubscription()) throw new UsernameNotFoundException("No account found. Please register with us!");

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) throw new PasswordsDontMatchException();

        return new ResponseEntity<>(String.valueOf(user.getId()),HttpStatus.OK);
    }

    //If this returns a 200 then the user is logged in
    @CrossOrigin(origins = "${react.url}")
    @GetMapping("/is_logged_in")
    public ResponseEntity<Object> amILoggedIn() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
