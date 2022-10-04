package com.example.getyourway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.getyourway.entities.RecommendedDestination;


@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    
}
