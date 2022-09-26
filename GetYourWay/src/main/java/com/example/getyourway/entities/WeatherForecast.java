package com.example.getyourway.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class WeatherForecast {
    @Id
    @GeneratedValue
    private int id;

    private Date localDate;
}
