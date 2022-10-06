package com.example.getyourway.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import com.example.getyourway.entities.RecommendedDestination;


@Repository
public interface RecommendedDestinationRepo extends JpaRepository<RecommendedDestination,Integer>{

    //List<RecommendedDestination> findAll();

    //@Query(value = "SELECT * from Recommended_Destination", nativeQuery = true)
    //List<RecommendedDestination> findAll();

    //@Query("SELECT p from Person p")
	//List<RecommendedDestination> findAllJPQL();

    //@Query(value = "SELECT * from RecommendedDestination", nativeQuery = true)
    
	//List<RecommendedDestination> findAllSQL();

}
