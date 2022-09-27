package com.example.getyourway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService{
    private final String baseUrl = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/weatherdata/forecast";
    private final String key = "4H8VPJ5U2NCJXSLAFEC5R4AQ5";

    @Autowired
    RestTemplate template;

    public ResponseEntity<String> getCurrentWeatherAt(String location) {

        String url = buildCurrentWeatherRequest()
                .queryParam("locations", String.format("%s", location))
                .encode()
                .toUriString();

        return template.exchange(
                url, HttpMethod.GET, null, String.class, "");

    }

    public ResponseEntity<String> getCurrentWeatherAt(float lat, float lon) {
        String url = buildCurrentWeatherRequest()
                .queryParam("locations", String.format("%f,%f", lat, lon))
                .encode()
                .toUriString();

        ResponseEntity<String> response = template.exchange(
                url, HttpMethod.GET, null, String.class, "");

        return response;
    }


    private UriComponentsBuilder buildCurrentWeatherRequest(){
        return UriComponentsBuilder.fromUriString(baseUrl)
                .queryParam("key",key)
                .queryParam("aggregateHours", 24)
                .queryParam("contentType", "json")
                .queryParam("unitGroup", "us")
                .queryParam("locationMode", "single");
    }

}