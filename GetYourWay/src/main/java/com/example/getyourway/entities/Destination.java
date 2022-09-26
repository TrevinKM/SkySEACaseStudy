package com.example.getyourway.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Destination {
    @Id
    private int id;

    private String name;

    private int localTransportHubId;

    @OneToOne
    private WeatherForecast weatherForecast;
}
