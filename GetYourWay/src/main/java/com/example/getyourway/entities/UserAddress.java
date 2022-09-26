package com.example.getyourway.entities;

import javax.persistence.*;

@Entity
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    private String lineOne;

    private String lineTwo;

    private String lineThree;

    private String postCode;
}
