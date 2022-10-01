package com.example.getyourway.controller;

import com.example.getyourway.DTOs.WeatherForecast;
import com.example.getyourway.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    @GetMapping(path = "/timeline")
    public ResponseEntity<List<WeatherForecast>> getWeatherBetween(@RequestParam String location, @RequestParam String startdate, @RequestParam String enddate) {
        try {
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            Date sd = s.parse(startdate);
            Date ed = s.parse(enddate);
            return weatherService.getForecastWeatherAt(sd, ed, location);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
        //return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

}
