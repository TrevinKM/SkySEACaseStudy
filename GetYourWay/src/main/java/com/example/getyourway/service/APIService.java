package com.example.getyourway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class APIService implements IAPIService {

    private static String url = "https://aerodatabox.p.rapidapi.com/airports/search/location/51.488269/-0.326488/km/200/9";
    private static String url2 = "https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyD9T7Iz3AHsGMeGNprGoIojX6CHfbuF4EE";

    public ResponseEntity<String> findCurrentLocation() {
        HttpHeaders headers = new HttpHeaders();
        //headers.set("API_KEY", "AIzaSyD9T7Iz3AHsGMeGNprGoIojX6CHfbuF4EE");
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> response = template.exchange(
                url2, HttpMethod.POST, requestEntity, String.class, "");
        return response;
    }

    public ResponseEntity<String> findFlightsNear() {
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
