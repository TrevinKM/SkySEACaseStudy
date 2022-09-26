package com.example.getyourway.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Airport extends Address{
    @Id
    @GeneratedValue
    public String IATA;

    public String airportName;
}
