package com.example.getyourway.service;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.Location;

public class AmadeusService {
    private Amadeus amadeus;

    private AmadeusService() {
        this.amadeus = Amadeus
                .builder("PhVBRYCtzGjsLJ6iuaaQRyeGlOv7NZql", "4XC0pJivQAlRH60v")
                .build();
    }
    public Location[] location(String keyword) throws ResponseException {
        return this.amadeus.referenceData.locations.get(Params
                .with("keyword", keyword)
                .and("subType", Locations.AIRPORT));
    }
}
