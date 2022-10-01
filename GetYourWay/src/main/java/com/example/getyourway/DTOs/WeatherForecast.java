package com.example.getyourway.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class WeatherForecast {
    private double temp;
    private double humidity;
    private double precip;
}