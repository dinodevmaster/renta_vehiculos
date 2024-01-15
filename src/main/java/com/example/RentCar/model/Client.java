package com.example.RentCar.model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "clients")
public class Client{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    @Column(unique = true)
    private String mail;
    private Date birthdate;
    private String telephone;
    private String address;
    private String zipCode;
}
