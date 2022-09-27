package com.example.getyourway.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService implements IAPIService {
    private final String baseUrl = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/";
    private final String key = "key=4H8VPJ5U2NCJXSLAFEC5R4AQ5";
    public ResponseEntity<String> findWeatherAt(String location) {

        //Parameterise this
        final String url = baseUrl + "timeline/"+  location + "?unitGroup=metric&" + key;

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Host", "aerodatabox.p.rapidapi.com");
        headers.set("X-RapidAPI-Key", "a5f276c5d2msh12b6c646a5ffa06p1f3221jsnd5d923c9a7f6");

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> response = template.exchange(
                url, HttpMethod.GET, requestEntity, String.class, "");
        //Object[] locations = restTemplate.getForObject(url, Object[].class);
        return response;
    }


}
