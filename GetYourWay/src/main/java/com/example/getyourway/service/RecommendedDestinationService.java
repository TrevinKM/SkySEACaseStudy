package com.example.getyourway.service;

import com.example.getyourway.entities.RecommendedDestination;
import com.example.getyourway.repositiories.RecommendedDestinationRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@Service
public class RecommendedDestinationService {

    private RecommendedDestinationRepo repo;

    @Autowired
    public RecommendedDestinationService(RecommendedDestinationRepo repo){
        super();
        this.repo = repo;
    }

    public String test(){return "Testing 1, 2, 3!";}
//should this read method call the jpql or sql version of findAll?   
    public List<RecommendedDestination> getAll() {
        return this.repo.findAll();
    }

}  
//public ResponseEntity<RecommendedDestination> getRecommendedDestination(@PathVariable(value = "id") Long id){
        //RecommendedDestination recommendedDestination = this.repo.findById(id).orElseThrow(
                //() -> new ResourceNotFoundException("This destination does not exist")
        //);
        //return ResponseEntity.ok().body(recommendedDestination);
    // /*} 

