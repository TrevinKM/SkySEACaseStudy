package com.example.getyourway.entities;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;


@Entity
public class Airport extends Address{
    @Id
    public String iataCode;

    public String airportName;
}
