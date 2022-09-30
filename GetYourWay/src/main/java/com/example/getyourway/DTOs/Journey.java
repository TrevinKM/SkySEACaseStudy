package com.example.getyourway.DTOs;

import lombok.Data;

import java.util.Date;

@Data
public class Journey {
    private int id;

    private Date startDate;
    private Date endDate;

    private Airport arrivalAirport;
    private Airport departureAirport;

    private Destination destination;

    private Address startAddress;
}
