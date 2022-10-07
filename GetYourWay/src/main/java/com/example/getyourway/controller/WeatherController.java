package com.example.getyourway.controller;

import com.example.getyourway.DTOs.WeatherForecast;
import com.example.getyourway.exceptions.InvalidDateException;
import com.example.getyourway.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping(path = "/current", params = {"location"})
    public ResponseEntity<WeatherForecast> getCurrentWeatherAt(@RequestParam("location") String location) {
        return weatherService.getCurrentWeatherAt(location);
    }

    @GetMapping(path = "/current", params = {"lat", "lon"})
    public ResponseEntity<WeatherForecast> getCurrentWeatherAt(@RequestParam("lat") float lat, @RequestParam("lon") float lon) {
        return weatherService.getCurrentWeatherAt(lat, lon);
    }

    @CrossOrigin(origins = "${react.url}")
    @GetMapping(path = "/timeline")
    public ResponseEntity<List<WeatherForecast>> getWeatherBetween(@RequestParam String location, @RequestParam String startdate, @RequestParam String enddate) {
        try {
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            Date sd = s.parse(startdate);
            Date ed = s.parse(enddate);
            return weatherService.getForecastWeatherAt(sd, ed, location);
        } catch (Exception e) {
            throw new InvalidDateException("The dates provided are in the incorrect format");
        }
    }

}
