package com.example.RentCar.controller;

import com.example.RentCar.dtos.CarDTO;
import com.example.RentCar.dtos.CreateCarDTO;
import com.example.RentCar.dtos.UpdateCarDTO;
import com.example.RentCar.service.companyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping()
    public List<CarDTO> getAllCars() {
        return companyService.getAllCompanies();
    }

    @GetMapping("{id}")
    public Optional<CarDTO> getCarByCompanyId(@PathVariable Long id) {
        return companyService.getCarByCompanyId(id);
    }

    @PostMapping()
    public CarDTO createCar(@Autowired @RequestBody CreateCarDTO newCar) {
        return companyService.createCar(newCar);
    }

    @PutMapping("{id}")
    public void UpdateCar(@PathVariable Long id, @RequestBody UpdateCarDTO newCar) {
        companyService.updateCar(id, newCar);
    }

    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable Long id) {
        companyService.deleteCar(id);

    }
}
