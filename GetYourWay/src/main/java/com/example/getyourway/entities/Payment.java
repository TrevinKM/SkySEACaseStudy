package com.example.getyourway.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Payment {
    @Id
    private int id;

    private int amount;
}
