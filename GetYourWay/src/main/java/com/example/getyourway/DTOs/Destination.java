package com.example.getyourway.DTOs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Destination {
    private int id;

    private String name;

    private int localTransportHubId;

    private WeatherForecast weatherForecast;
}
