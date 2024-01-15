package com.example.RentCar.controller;

import com.example.RentCar.dtos.CarDTO;
import com.example.RentCar.dtos.CreateCarDTO;
import com.example.RentCar.dtos.UpdateCarDTO;
import com.example.RentCar.model.Car;
import com.example.RentCar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping()
    public List<CarDTO> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("{id}")
    public Optional<CarDTO> getCarByCompanyId(@PathVariable Long id) {
        return carService.getCarByCompanyId(id);
    }

    @PostMapping()
    public CarDTO createCar(@Autowired @RequestBody CreateCarDTO newCar) {
        return carService.createCar(newCar);
    }

    @PutMapping("{id}")
    public void UpdateCar(@PathVariable Long id, @RequestBody UpdateCarDTO newCar) {
        carService.updateCar(id, newCar);
    }

    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);

    }

    @GetMapping("/enabledCar/{id}")
    public ResponseEntity<Car> enabledCar(@PathVariable Long id) {
        return carService.enabledCar(id);
    }

    @GetMapping("/disabledCar/{id}")
    public void disabledCar(@PathVariable Long id) {
        carService.disabledCar(id);
    }
}
