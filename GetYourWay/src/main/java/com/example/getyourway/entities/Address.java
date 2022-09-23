package com.example.getyourway.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private int id;

    private String lineOne;

    private String lineTwo;

    private String lineThree;

    private String postCode;
}
