package com.example.getyourway.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private Long userID;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private byte[] photo;

    public User(String firstname, String lastname, String username, String email, byte[] photo) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.photo = photo;
    }

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
