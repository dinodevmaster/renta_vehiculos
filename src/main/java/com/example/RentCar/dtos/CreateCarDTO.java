package com.example.RentCar.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCarDTO {
    private Long idCompany;
    @NotBlank
    private String mark;
    @NotBlank
    private String model;
    private int year;
    @NotBlank
    private String patent;
    @NotBlank
    private String size;
    @NotBlank
    private String category;
    private Float rentCost;
    private boolean enable;
}
