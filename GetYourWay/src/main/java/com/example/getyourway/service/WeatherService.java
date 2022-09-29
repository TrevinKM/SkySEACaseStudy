package com.example.getyourway.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
@Service

public class WeatherService {
    private final String baseUrl = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/weatherdata/forecast";
    private final String key = "4H8VPJ5U2NCJXSLAFEC5R4AQ5";

    @Autowired
    RestTemplate template;

    public ResponseEntity<Weather> getCurrentWeatherAt(String location) {

        String url = buildCurrentWeatherRequest()
                .queryParam("locations", String.format("%s", location))
                .encode()
                .toUriString();

        return getCurrentWeatherResponse(url);
    }

    public ResponseEntity<Weather> getCurrentWeatherAt(float lat, float lon) {
        String url = buildCurrentWeatherRequest()
                .queryParam("locations", String.format("%f,%f", lat, lon))
                .encode()
                .toUriString();

        return getCurrentWeatherResponse(url);
    }

    private ResponseEntity<Weather> getCurrentWeatherResponse(String url) {
        ResponseEntity<String> response = template.exchange(
                url, HttpMethod.GET, null, String.class, "");

        JSONObject weather = new JSONObject(response.getBody())
                .getJSONObject("location")
                .getJSONObject("currentConditions");

        Weather result = (Weather)mapJSONToClass(weather, Weather.class);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private Object mapJSONToClass(JSONObject json, Class c){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json.toString(), Weather.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    private UriComponentsBuilder buildCurrentWeatherRequest() {
        return UriComponentsBuilder.fromUriString(baseUrl)
                .queryParam("key", key)
                .queryParam("aggregateHours", 24)
                .queryParam("contentType", "json")
                .queryParam("unitGroup", "us")
                .queryParam("locationMode", "single");
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Weather{
        public double temp;
        public double humidity;
        public double precip;
    }

}