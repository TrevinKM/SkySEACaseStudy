package com.example.getyourway.controller;

import com.example.getyourway.service.APIService;
import com.example.getyourway.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;
    @GetMapping(path= "/weather", params = {"location"})
    public ResponseEntity<String> getCurrentWeatherAt(@RequestParam("location") @NotNull String location) {
        return weatherService.getCurrentWeatherAt(location);
    }
    @GetMapping(path= "/weather", params = {"lat", "lon"})
    public ResponseEntity<String> getCurrentWeatherAt(@RequestParam(value = "lat") float lat, @RequestParam("lon") float lon){
        return weatherService.getCurrentWeatherAt(lat, lon);
    }

}
