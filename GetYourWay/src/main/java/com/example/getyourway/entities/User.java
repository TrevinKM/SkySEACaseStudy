package com.example.getyourway.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    private String firstname;

    private String lastname;

    private String username;

    private String email;




    private byte[] photo;
    /*
        public boolean hasSubscription() {
        return subscription != null && !subscription.hasExpired();
    }

    @OneToOne
    private Subscription subscription;

    @ManyToOne
    private Address address;

    @ManyToMany
    private List<Payment> payments;

     */

}
