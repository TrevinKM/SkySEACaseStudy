package com.example.getyourway.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subscription")
@Setter
@Getter
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private Date startDate;

    public boolean hasExpired() {
        return new Date().before(endDate);
    }

    private Date endDate;

    @OneToOne(mappedBy = "subscription")
    private User user;

    private String stripeId;
}
