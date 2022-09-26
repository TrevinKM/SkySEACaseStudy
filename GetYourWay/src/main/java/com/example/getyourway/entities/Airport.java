package com.example.getyourway.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Airport {
    @Id
    @GeneratedValue
    private String IATA;

    private String airportName;
}
