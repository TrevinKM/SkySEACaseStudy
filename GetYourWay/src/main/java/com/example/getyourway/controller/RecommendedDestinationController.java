package com.example.getyourway.controller;
import com.example.getyourway.entities.RecommendedDestination;
import com.example.getyourway.exceptions.ResourceNotFoundException;
import com.example.getyourway.repositiories.RecommendedDestinationRepo;
import com.example.getyourway.service.RecommendedDestinationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/recommended_destination")
public class RecommendedDestinationController {
    
    private RecommendedDestinationService service;
    @Autowired
    public RecommendedDestinationController (RecommendedDestinationService service){
        super();
        this.service = service;
    }

    @GetMapping("/test")
    public String test(){return this.service.test();}

    @GetMapping("/show")
    public ResponseEntity<List<RecommendedDestination>> getRecommendedDestination(){
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecommendedDestination> getRecommendedDestination(@PathVariable(value = "id") Long id){
        RecommendedDestination recommendedDestination = this.service.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("This destination does not exist")
        );
        return ResponseEntity.ok().body(recommendedDestination);
    }
}
