package com.example.getyourway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/api")
@RestController
public class APIController {

    @Autowired
    private RestTemplate restTemplate;

    private static String url = "https://aerodatabox.p.rapidapi.com/airports/search/location/51.488269/-0.326488/km/200/9";




    @GetMapping("/locations")
    public ResponseEntity<String> getLocations(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Host", "aerodatabox.p.rapidapi.com");
        headers.set("X-RapidAPI-Key", "a5f276c5d2msh12b6c646a5ffa06p1f3221jsnd5d923c9a7f6");
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.GET, requestEntity, String.class, "");
        //Object[] locations = restTemplate.getForObject(url, Object[].class);
        return response;
    }


}
