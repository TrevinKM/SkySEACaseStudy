package com.example.getyourway.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Subscription {

    @Id
    @GeneratedValue
    private int id;

    private Date startDate;

    private Date endDate;
}
