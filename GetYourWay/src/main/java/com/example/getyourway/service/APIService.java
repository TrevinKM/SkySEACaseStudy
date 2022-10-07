package com.example.getyourway.service;

import com.example.getyourway.DTOs.AddressResult;
import com.example.getyourway.DTOs.Response;
import com.example.getyourway.DTOs.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class APIService {
    @Autowired
    private RestTemplate template = new RestTemplate();

    //private static String url = "https://aerodatabox.p.rapidapi.com/airports/search/location/51.488269/-0.326488/km/200/9";
    //private static String url2 = "https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyD9T7Iz3AHsGMeGNprGoIojX6CHfbuF4EE";

    public ResponseEntity<Response> findCurrentLocation() {
        HttpHeaders headers = new HttpHeaders();

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("www.googleapis.com")
                .path("/geolocation/v1/geolocate")
                .query("key={api_key}")
                .buildAndExpand("AIzaSyD9T7Iz3AHsGMeGNprGoIojX6CHfbuF4EE");

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Response> response = template.exchange(
                uriComponents.toString(), HttpMethod.POST, requestEntity, Response.class, "");
        return response;
    }

    // https://maps.googleapis.com/maps/api/geocode/json?address=Washington&key=AIzaSyD9T7Iz3AHsGMeGNprGoIojX6CHfbuF4EE
    public ResponseEntity<Result> findGeolocation(String address) {
        HttpHeaders headers = new HttpHeaders();

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("maps.googleapis.com")
                .path("/maps/api/geocode/json")
                .query("address={address}&key={api_key}")
                .buildAndExpand(address,"AIzaSyD9T7Iz3AHsGMeGNprGoIojX6CHfbuF4EE")
                .encode();
        //System.out.println(uriComponents.toString());
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Result> response = template.exchange(
                uriComponents.toString(), HttpMethod.GET, requestEntity, Result.class, "");
        System.out.println(response.getBody().getFormattedAddress());
        return response;
    }

    //https://maps.googleapis.com/maps/api/geocode/json?latlng=40.714224,-73.961452&key=AIzaSyD9T7Iz3AHsGMeGNprGoIojX6CHfbuF4EE

    public ResponseEntity<Result> findReverseGeolocation(double lat, double lng) {
        HttpHeaders headers = new HttpHeaders();

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("maps.googleapis.com")
                .path("/maps/api/geocode/json")
                .query("latlng={latitude},{longitude}&key={api_key}")
                .buildAndExpand(lat,lng,"AIzaSyD9T7Iz3AHsGMeGNprGoIojX6CHfbuF4EE")
                .encode();
//        System.out.println(uriComponents.toString());
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Result> response = template.exchange(
                uriComponents.toString(), HttpMethod.GET, requestEntity, Result.class, "");
        //System.out.println(((Object) response).getClass().getSimpleName());
        //System.out.println(((Object) response.getBody()).getClass().getSimpleName());
        return response;
    }

    public ResponseEntity<String> findFlightsNear(double lat, double lng) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Host", "aerodatabox.p.rapidapi.com");
        headers.set("X-RapidAPI-Key", "a5f276c5d2msh12b6c646a5ffa06p1f3221jsnd5d923c9a7f6");

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("aerodatabox.p.rapidapi.com")
                .path("/airports/search/location/{latitude}/{longitude}/km/500/9")
                .buildAndExpand(Double.toString(lat), Double.toString(lng));

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> response = template.exchange(
                uriComponents.toString(), HttpMethod.GET, requestEntity, String.class, "");
        return response;
    }

}
