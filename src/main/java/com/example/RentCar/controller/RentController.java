package com.example.RentCar.controller;

import com.example.RentCar.dtos.CreateRentDTO;
import com.example.RentCar.dtos.RentDTO;
import com.example.RentCar.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rent")
public class RentController {
    @Autowired
    private RentService rentService;

    @PostMapping()
    public RentDTO rent(@RequestBody CreateRentDTO rent) {
        return rentService.rent(rent);
    }

}
