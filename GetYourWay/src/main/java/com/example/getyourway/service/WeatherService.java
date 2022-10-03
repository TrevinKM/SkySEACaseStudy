package com.example.getyourway.service;

import com.example.getyourway.DTOs.WeatherForecast;
import com.example.getyourway.exceptions.IncompatibleResponseException;
import com.example.getyourway.exceptions.InvalidCoordException;
import com.example.getyourway.exceptions.InvalidDateException;
import com.example.getyourway.exceptions.ServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class WeatherService {
    private final String baseUrl = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services";
    private final String key = "4H8VPJ5U2NCJXSLAFEC5R4AQ5";

    @Autowired
    RestTemplate template;

    public ResponseEntity<WeatherForecast> getCurrentWeatherAt(String location) {
        String url = getCurrentWeatherURL(String.format("%s", location));
        return getCurrentWeatherResponse(url);
    }

    public ResponseEntity<WeatherForecast> getCurrentWeatherAt(float lat, float lon) {
        if (lat < -90 || lat > 90 || lon < -180 || lon > 180) throw new InvalidCoordException();

        String url = getCurrentWeatherURL(String.format("%f,%f", lat, lon));
        return getCurrentWeatherResponse(url);
    }

    public ResponseEntity<List<WeatherForecast>> getForecastWeatherAt(Date startDate, Date endDate, String location) {
        if (startDate.after(endDate)) throw new InvalidDateException("End date must be before start date");

        String url = getWeatherBetweenURL(startDate, endDate, location);
        return getWeatherBetweenResponse(url);
    }

    private ResponseEntity<WeatherForecast> getCurrentWeatherResponse(String url) throws ServiceException {
        ResponseEntity<String> response = template.exchange(
                url, HttpMethod.GET, null, String.class, "");

        JSONObject weather = new JSONObject(response.getBody())
                .getJSONObject("location")
                .getJSONObject("currentConditions");

        WeatherForecast result = (WeatherForecast) mapJSONToClass(weather, WeatherForecast.class);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private ResponseEntity<List<WeatherForecast>> getWeatherBetweenResponse(String url) {
        ResponseEntity<String> response = template.exchange(
                url, HttpMethod.GET, null, String.class, "");

        JSONArray weatherWeek = new JSONObject(response.getBody())
                .getJSONArray("days");

        List<WeatherForecast> weeksWeather = new ArrayList<>();

        for (int i = 0; i < weatherWeek.length(); i++) {
            weeksWeather.add((WeatherForecast) mapJSONToClass(weatherWeek.getJSONObject(i), WeatherForecast.class));
        }

        return new ResponseEntity<>(weeksWeather, HttpStatus.OK);
    }

    private String getCurrentWeatherURL(String location) {
        return UriComponentsBuilder.fromUriString(baseUrl + "/weatherdata/forecast")
                .queryParam("key", key)
                .queryParam("aggregateHours", 24)
                .queryParam("contentType", "json")
                .queryParam("unitGroup", "us")
                .queryParam("locationMode", "single")
                .queryParam("locations", location).encode().toUriString();
    }

    private String getWeatherBetweenURL(Date startDate, Date endDate, String location) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, String> parameters = new HashMap<>();
        parameters.put("location", location);
        parameters.put("date1", df.format(startDate));
        parameters.put("date2", df.format(endDate));
        return UriComponentsBuilder.fromUriString(baseUrl)
                .path("/timeline/{location}/{date1}/{date2}")
                .queryParam("key", key)
                .queryParam("include", "days")
                .build(parameters).toString();
    }


    private Object mapJSONToClass(JSONObject json, Class c) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json.toString(), c);
        } catch (JsonProcessingException e) {
            throw new IncompatibleResponseException("Unable to parse JSON", e);
        }
    }
}