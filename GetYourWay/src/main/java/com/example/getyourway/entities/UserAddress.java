package com.example.getyourway.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "useraddress")
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Size(min=1, max=60)
    private String lineOne;
    @Size(min=1, max=60)
    private String lineTwo;
    @Size(min=1, max=60)
    private String lineThree;
    @Size(min=6, max=8)//letters and numbers - add regex?
    private String postCode;
}
