package com.example.RentCar.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
public class UpdateClientDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    private String mail;

    @DateTimeFormat(pattern = "yyyy--MM-dd")
    private Date birthdate;

    @NotBlank
    private String telephone;
    @NotBlank
    private String address;
    @NotBlank
    private String zipCode;
}
