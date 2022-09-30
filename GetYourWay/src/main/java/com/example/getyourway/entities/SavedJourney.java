package com.example.getyourway.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class SavedJourney {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date startDate;
    private Date endDate;

    /*
    @OneToMany
    private Airport arrivalAirport;

    @OneToMany
    private Airport departureAirport;
    */

}
