package com.example.getyourway.controller;

import com.amadeus.resources.Traveler;
import com.example.getyourway.DTOs.Response;
import com.example.getyourway.DTOs.Result;
import com.example.getyourway.exceptions.ResourceNotFoundException;
import com.example.getyourway.service.APIService;
import com.example.getyourway.service.DBConnect;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.amadeus.resources.Location;
import com.amadeus.exceptions.ResponseException;
import com.example.getyourway.service.AmadeusConnect;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.FlightPrice;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class APIController {

    /**
     * Testing
     * **/

    @Autowired
    private APIService apiService;

    //private static String url = "https://aerodatabox.p.rapidapi.com/airports/search/location/51.488269/-0.326488/km/200/9";

    //private RestTemplate restTemplate;

    //private static String url = "https://aerodatabox.p.rapidapi.com/airports/search/location/51.488269/-0.326488/km/200/9";

//query function name - gets airports rather than flights so should we change it?

    //Find current live location in lat lng
    @GetMapping("/location")
    public ResponseEntity<Response> getCurrentLocation(){
        return apiService.findCurrentLocation();
    }
    //Change lat lng to text(good for turning the above live location to text)
    @GetMapping("/address")
    @ResponseBody
    @CrossOrigin(origins = "${react.url}")

    public ResponseEntity<Result> getAddress(
            @RequestParam(name = "lat") double lat,
            @RequestParam(name = "lng") double lng
    )
    {
        return apiService.findReverseGeolocation(lat, lng);
    }
    //Change postcode to lat lng/address
    @GetMapping("/coordinates")
    @ResponseBody
    @CrossOrigin(origins = "${react.url}")
    public ResponseEntity<Result> getLatLng(
            @RequestParam(name = "address") String address
    )
    {

        return apiService.findGeolocation(address);
    }

    //Find airports near a certain lat lng location (using amadeus api instead now)
    @GetMapping("/airports")
    @ResponseBody
    @CrossOrigin(origins = "${react.url}")
    public ResponseEntity<?> getAirPorts(
            @RequestParam(name = "lat") double lat,
            @RequestParam(name = "lng") double lng
    )
    {
        return apiService.findFlightsNear(lat, lng);
    }


    //Flights between two destinations
    //Airports by iata code
    @GetMapping("/airportlocations")
    @CrossOrigin(origins = "${react.url}")
    public Location[] locations(
            @RequestParam(name = "keyword") String keyword
    )
    {
        try {
            return AmadeusConnect.INSTANCE.location(keyword);
        } catch (IndexOutOfBoundsException | ResponseException e) {
            return new Location[0];
        }
    }
    @GetMapping("/flights")
    @CrossOrigin(origins = "${react.url}")
    public FlightOfferSearch[] flights(@RequestParam(name = "origin") String origin,
                                       @RequestParam(name = "destination") String destination,
                                       @RequestParam(name = "departDate") String departDate,
                                       @RequestParam(name = "adults") String adults,
                                       @RequestParam(required = false, name = "returnDate") String returnDate)
            throws ResponseException {
        return AmadeusConnect.INSTANCE.flights(origin, destination, departDate, adults, returnDate);
    }
    @PostMapping("/confirm")
    @CrossOrigin(origins = "${react.url}")
    public FlightPrice confirm(@RequestBody(required=true) FlightOfferSearch search) throws ResponseException {
        return AmadeusConnect.INSTANCE.confirm(search);
    }
    //
    @PostMapping("/traveler")
    @CrossOrigin(origins = "${react.url}")
    public Traveler traveler(@RequestBody(required=true) JsonObject travelerInfo) {
        return DBConnect.traveler(travelerInfo.get("data").getAsJsonObject());
    }


    @GetMapping("/flight")
    public ResponseEntity<Response> getLiveLocations(){
        return apiService.findCurrentLocation();
    }
}
