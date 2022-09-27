package com.example.getyourway.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WeatherService implements IAPIService {
    private final String baseUrl = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/";
    private final String key = "key=4H8VPJ5U2NCJXSLAFEC5R4AQ5";

    public ResponseEntity<String> getCurrentWeatherAt(String location) {

        //TODO:proper request building
        final String url = baseUrl + "weatherdata/forecast?aggregateHours=24&contentType=json&unitGroup=us&locationMode=single&locations=" + location + "&" + key;

        HttpEntity<Void> requestEntity = new HttpEntity<>(null);
        ResponseEntity<String> response = template.exchange(
                url, HttpMethod.GET, requestEntity, String.class, "");

        return response;
    }

    public ResponseEntity<String> getCurrentWeatherAt(float lon, float lat) {
        //TODO:proper request building

        final String url = baseUrl + "weatherdata/forecast?aggregateHours=24&contentType=json&unitGroup=us&locationMode=single&locations=leeds&" + key;

        HttpEntity<Void> requestEntity = new HttpEntity<>(null);
        ResponseEntity<String> response = template.exchange(
                url, HttpMethod.GET, requestEntity, String.class, "");

        return response;
    }

}