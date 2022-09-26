package com.example.getyourway.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class WeatherForecast {
    @Id
    private int id;

    private Date localDate;
}
