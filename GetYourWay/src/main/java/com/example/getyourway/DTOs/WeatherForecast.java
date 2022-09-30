package com.example.getyourway.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class WeatherForecast{
    private double temp;
    private double humidity;
    private double precip;
}