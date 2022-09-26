package com.example.getyourway.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Journey {
    @Id
    public int id;
    public Date startDate;
    public Date endDate;

    //Should these be airport class?
    public String departureIATA;
    public String arrivalIATA;
    public String departurePlace;
    public String arrivalPlace;
}
