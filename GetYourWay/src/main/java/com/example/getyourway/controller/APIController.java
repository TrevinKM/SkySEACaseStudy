package com.example.getyourway.controller;

import com.example.getyourway.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class APIController {

    /**
     * Testing
     **/

    @Autowired
    private APIService apiService;

    //private static String url = "https://aerodatabox.p.rapidapi.com/airports/search/location/51.488269/-0.326488/km/200/9";

    private RestTemplate restTemplate;

    private static final String url = "https://aerodatabox.p.rapidapi.com/airports/search/location/51.488269/-0.326488/km/200/9";

    //query function name - gets airports rather than flights so should we change it?
    @GetMapping("/locations")
    public ResponseEntity<String> getLocations() {
        return apiService.findFlightsNear();
    }

    @GetMapping("/locations/live")
    public ResponseEntity<String> getLiveLocations() {
        return apiService.findCurrentLocation();
    }
}
