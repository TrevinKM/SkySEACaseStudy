package com.example.getyourway.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Payment {
    @Id
    @GeneratedValue
    private int id;

    private int amount;
}
