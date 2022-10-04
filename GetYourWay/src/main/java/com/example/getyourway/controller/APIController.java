package com.example.getyourway.controller;

import com.example.getyourway.DTOs.Response;
import com.example.getyourway.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.Location;
import com.amadeus.exceptions.ResponseException;
import com.example.getyourway.service.AmadeusConnect;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.FlightPrice;


@RestController
@RequestMapping("/api")
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

    //Find current live location in lat lng -> convert to location
    @GetMapping("/location")
    public ResponseEntity<String> getLocations(){
        ResponseEntity<Response> response = apiService.findCurrentLocation();
        return apiService.findFlightsNear(response.getBody().getLocation().getLat(), response.getBody().getLocation().getLng());
    }
    //Change lat lng to text(good for turning the above live location to text)
    @GetMapping("/address")
    @ResponseBody
    public ResponseEntity<String> getAddress(
            @RequestParam(name = "lat") double lat,
            @RequestParam(name = "lng") double lng
    )
    {
        return apiService.findReverseGeolocation(lat, lng);
    }
    //Change postcode to lat lng/address
    @GetMapping("/coordinates")
    @ResponseBody
    public ResponseEntity<String> getLatLng(
            @RequestParam(name = "address") String address
    )
    {

        return apiService.findGeolocation(address);
    }

    //Find airports near a certain lat lng location
    @GetMapping("/airports")
    @ResponseBody
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
    public Location[] locations(
            @RequestParam(name = "keyword") String keyword
    ) throws ResponseException
    {
        return AmadeusConnect.INSTANCE.location(keyword);
    }
    @GetMapping("/flights")
    public FlightOfferSearch[] flights(@RequestParam(name = "origin") String origin,
                                       @RequestParam(name = "destination") String destination,
                                       @RequestParam(name = "departDate") String departDate,
                                       @RequestParam(name = "adults") String adults,
                                       @RequestParam(required = false, name = "returnDate") String returnDate)
            throws ResponseException {
        return AmadeusConnect.INSTANCE.flights(origin, destination, departDate, adults, returnDate);
    }
    @PostMapping("/confirm")
    public FlightPrice confirm(@RequestBody(required=true) FlightOfferSearch search) throws ResponseException {
        return AmadeusConnect.INSTANCE.confirm(search);
    }
    //
    @GetMapping("/flight")
    public ResponseEntity<Response> getLiveLocations(){
        return apiService.findCurrentLocation();
    }
}
