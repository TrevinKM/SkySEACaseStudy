package com.example.getyourway.entities;

import javax.persistence.*;

//TODO: Move to DTO
@Entity
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private int localTransportHubId;
/*
    @OneToOne
    private WeatherForecast weatherForecast;
 */
}
