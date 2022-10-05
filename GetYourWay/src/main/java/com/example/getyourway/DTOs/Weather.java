package com.example.getyourway.DTOs;

import lombok.Data;

import java.util.List;

@Data
public class Weather {
    private List<WeatherForecast> historical;

    private List<WeatherForecast> forecast;

    private WeatherForecast current;
}
