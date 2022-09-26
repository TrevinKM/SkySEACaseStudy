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
    public int id;
    public Date startDate;
    public Date endDate;

    //Should these be airport class?
    /*
    public String departureIATA;
    public String arrivalIATA;
    public String departurePlace;
    public String arrivalPlace;
     */

    @OneToOne
    public Airport arrivalAirport;

    @OneToOne
    public Airport departureAirport;

}
