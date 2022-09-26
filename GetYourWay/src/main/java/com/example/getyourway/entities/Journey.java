package com.example.getyourway.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Journey {
    @Id
    @GeneratedValue
    private int id;

    private Date startDate;
    private Date endDate;
/*
    @OneToOne
    private Airport arrivalAirport;

    @OneToOne
    private Airport departureAirport;
    
 */

}
