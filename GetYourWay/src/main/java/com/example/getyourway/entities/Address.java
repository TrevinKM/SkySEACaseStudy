package com.example.getyourway.entities;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private String lineOne;

    private String lineTwo;

    private String lineThree;

    private String postCode;
}
