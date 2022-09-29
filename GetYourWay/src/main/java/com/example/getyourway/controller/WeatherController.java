package com.example.getyourway.controller;

import com.example.getyourway.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping(path = "/current", params = {"location"})
    public ResponseEntity<WeatherService.Weather> getCurrentWeatherAt(@RequestParam("location") String location) {
        return weatherService.getCurrentWeatherAt(location);
    }

    @GetMapping(path = "/current", params = {"lat", "lon"})
    public ResponseEntity<WeatherService.Weather> getCurrentWeatherAt(@RequestParam("lat") float lat, @RequestParam("lon") float lon) {
        return weatherService.getCurrentWeatherAt(lat, lon);
    }

}
