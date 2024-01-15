package com.example.RentCar.service;

import com.example.RentCar.dtos.CarDTO;
import com.example.RentCar.dtos.CreateCarDTO;
import com.example.RentCar.dtos.UpdateCarDTO;
import com.example.RentCar.exceptions.ResourceNotFoundExceptions;
import com.example.RentCar.mapper.CarMapper;
import com.example.RentCar.model.Car;
import com.example.RentCar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarMapper carMapper;


    public List<CarDTO> getAllCars() {
        return carMapper.toDTO(carRepository.findAll());
    }

    public Optional<CarDTO> getCarByCompanyId(@PathVariable Long id) {
        return Optional.of(carMapper.toDTO(carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("No existe un vehículo con el id: " + id))));
    }

    public CarDTO createCar(CreateCarDTO newCar) {
        return carMapper.toDTO(carRepository.save(carMapper.toModel(newCar)));
    }

    public void updateCar(long id, UpdateCarDTO data){
        Optional<Car> row = carRepository.findById(id);
        Car car = row.get();
        carMapper.update(car,data);
        carRepository.save(car);
    }

    public void deleteCar(long id){
        Optional<Car> row = carRepository.findById(id);
        Car car = row.get();
        carRepository.delete(car);
    }

    public ResponseEntity<Car> enabledCar(long id){
        Car car = carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("No existe un vehículo con el id: " + id));
        car.setEnable(true);
        carRepository.save(car);
        return ResponseEntity.ok(car);
    }

    public void disabledCar(long id){
        Car car = carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("No existe un vehículo con el id: " + id));
        car.setEnable(false);
        carRepository.save(car);
    }
}
