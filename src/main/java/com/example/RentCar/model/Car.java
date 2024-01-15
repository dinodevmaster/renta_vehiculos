package com.example.RentCar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idCompany;
    private String mark;
    private String model;
    private int year;
    private String patent;
    private String size;
    private String category;
    private Float rentCost;
    private boolean enable;
}
