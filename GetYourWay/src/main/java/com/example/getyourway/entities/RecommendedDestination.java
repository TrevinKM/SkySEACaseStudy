package com.example.getyourway.entities;

import javax.persistence.*;

@Entity
public class RecommendedDestination {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String arrivalIATACode;

    private String skyShow;

    private String destinationInfo;


}
