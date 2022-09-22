package com.example.getyourway;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Object[] getLocations(){
        Object[] locations = restTemplate.getForObject(url, Object[].class);
        return locations;
    }


}
