package com.example.getyourway.controller;

import com.example.getyourway.DTOs.LoginRequest;
import com.example.getyourway.DTOs.Password;
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
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepo.save(user);
        return new ResponseEntity<>(String.valueOf(user.getId()), HttpStatus.OK);
    }

    @CrossOrigin(origins = "${react.url}")
    @PostMapping("/userLogin")
    public ResponseEntity<String> userLogin(@RequestBody LoginRequest request){

        User user = userRepo.findByEmailAddress(request.getEmail());
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        boolean matches = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if(matches && user.hasSubscription()) return new ResponseEntity<>(String.valueOf(user.getId()),HttpStatus.OK);

        return new ResponseEntity<>("-1", HttpStatus.BAD_REQUEST);
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
