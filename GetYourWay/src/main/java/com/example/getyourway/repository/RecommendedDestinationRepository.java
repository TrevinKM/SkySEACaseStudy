package com.example.getyourway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import com.example.getyourway.entities.RecommendedDestination;


@Repository
public interface RecommendedDestinationRepository extends JpaRepository<RecommendedDestination,Long>{
    List<RecommendedDestination> findRecommendedDestination();

    @Query("SELECT p from Person p")
	List<RecommendedDestination> findAllJPQL();

    @Query(value = "SELECT * from RecommendedDestination", nativeQuery = true)
	List<RecommendedDestination> findAllSQL();

}