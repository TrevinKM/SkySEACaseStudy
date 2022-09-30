package com.example.getyourway.DTOs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Journey {
    private int id;

    private Date startDate;
    private Date endDate;

    private Airport arrivalAirport;
    private Airport departureAirport;

    private Destination destination;

    private Address startPoint;
}
