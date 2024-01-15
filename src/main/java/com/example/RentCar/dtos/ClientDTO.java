package com.example.RentCar.dtos;

import lombok.Data;

import java.sql.Date;

@Data
public class ClientDTO {
    private Long id;
    private String name;
    private String lastName;
    private String mail;
    private Date birthdate;
    private String telephone;
    private String address;
    private String zipCode;
}
