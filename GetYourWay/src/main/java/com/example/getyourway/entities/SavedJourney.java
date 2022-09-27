package com.example.getyourway.entities;

import javax.persistence.*;
import java.util.Date;


//TODO: Move to DTO
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
