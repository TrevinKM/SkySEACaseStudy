package com.example.getyourway.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    private String firstname;

    private String lastname;

    private String username;

    private String email;

    private byte[] photo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription_id", referencedColumnName = "id")
    private Subscription subscription;

    public boolean hasSubscription() {
        return subscription != null && !subscription.hasExpired();
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "useraddress_id", referencedColumnName = "id")
    private UserAddress address;

    @OneToMany
    private List<Payment> payments;

    public static Object withDefaultPasswordEncoder() {
        return null;
    }

}
