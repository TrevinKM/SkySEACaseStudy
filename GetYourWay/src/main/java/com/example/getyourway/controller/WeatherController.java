package com.example.getyourway.controller;

import com.example.getyourway.service.APIService;
import com.example.getyourway.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;
    @GetMapping("/weather")
    public ResponseEntity<String> getCurrentWeatherAt(){
        return weatherService.findWeatherAt("Leeds");
    }

}
