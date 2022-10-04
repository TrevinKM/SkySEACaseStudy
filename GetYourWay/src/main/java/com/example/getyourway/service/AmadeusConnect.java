package com.example.getyourway.service;

import com.google.gson.Gson;
import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.FlightPrice;
import com.amadeus.resources.Location;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.exceptions.ResponseException;
import org.springframework.stereotype.Service;

public enum AmadeusConnect {
    INSTANCE;
    private Amadeus amadeus;
    private AmadeusConnect() {
        this.amadeus = Amadeus
                .builder("PhVBRYCtzGjsLJ6iuaaQRyeGlOv7NZql", "4XC0pJivQAlRH60v")
                .build();
    }
    public Location[] location(String keyword) throws ResponseException {
        return amadeus.referenceData.locations.get(Params
                .with("keyword", keyword)
                .and("subType", Locations.AIRPORT));
    }

    public FlightOfferSearch[] flights(String origin, String destination, String departDate, String adults, String returnDate) throws ResponseException {
        return amadeus.shopping.flightOffersSearch.get(
                Params.with("originLocationCode", origin)
                        .and("destinationLocationCode", destination)
                        .and("departureDate", departDate)
                        .and("returnDate", returnDate)
                        .and("adults", adults)
                        .and("max", 5));
    }

    public FlightPrice confirm(FlightOfferSearch offer) throws ResponseException {
        return amadeus.shopping.flightOffersSearch.pricing.post(offer);
    }
}