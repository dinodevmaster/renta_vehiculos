package com.example.RentCar.service;

import com.example.RentCar.dtos.CreateRentDTO;
import com.example.RentCar.dtos.RentDTO;
import com.example.RentCar.mapper.RentMapper;
import com.example.RentCar.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService {
    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private RentMapper rentMapper;

    public RentDTO rent(CreateRentDTO data){
        return rentMapper.toDTO(rentRepository.save(rentMapper.toModel(data)));
    }

}
