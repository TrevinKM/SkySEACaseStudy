package com.example.getyourway.service;

import com.example.getyourway.Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import lombok.AllArgsConstructor;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Generated;
import java.util.List;
import java.util.Map;

@Service
public class WeatherService {
    private final String baseUrl = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/weatherdata/forecast";
    private final String key = "4H8VPJ5U2NCJXSLAFEC5R4AQ5";

    @Autowired
    RestTemplate template;

    public ResponseEntity<String> getCurrentWeatherAt(String location) {

        String url = buildCurrentWeatherRequest()
                .queryParam("locations", String.format("%s", location))
                .encode()
                .toUriString();

        ResponseEntity<String> response = template.exchange(
                url, HttpMethod.GET, null, String.class, "");
        return response;
    }

    public ResponseEntity<String> getCurrentWeatherAt(float lat, float lon) {
        String url = buildCurrentWeatherRequest()
                .queryParam("locations", String.format("%f,%f", lat, lon))
                .encode()
                .toUriString();

        ResponseEntity<String> response = template.exchange(
                url, HttpMethod.GET, null, String.class, "");

        JSONObject weather = new JSONObject(response.getBody()).getJSONObject("location").getJSONArray("values").getJSONObject(0);
        Weather result = (Weather)mapJSONToClass(weather.toString(), Weather.class);

        System.out.print(result.temp);
        return response;
    }

    private Object mapJSONToClass(String json, Class c){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json.toString(), Weather.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
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
    }

}