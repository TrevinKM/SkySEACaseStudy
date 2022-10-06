package com.example.getyourway.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private int id;

    @Size(min = 1, max = 30)
    private String firstName;
    @Size(min = 1, max = 30)
    private String lastName;
    //@Pattern (clever regex here + import)
    @Column(name="email_address", nullable = false)
    private String emailAddress;
    //some sort of size constraint here 400kb? and file type(s)
    private byte[] imageFile;

    private boolean enabled;
    @Size(min = 8, max = 60)

    private String password;

    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription_id", referencedColumnName = "id")
    private Subscription subscription;

    public boolean hasSubscription() {
        return subscription != null && !subscription.hasExpired();
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "useraddress_id", referencedColumnName = "id")
    private UserAddress address;

    //@OneToMany
    //private List<Payment> payments;

    public static Object withDefaultPasswordEncoder() {
        return null;
    }

}
