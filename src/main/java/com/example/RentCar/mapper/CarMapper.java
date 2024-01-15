package com.example.RentCar.mapper;

import com.example.RentCar.dtos.*;
import com.example.RentCar.model.Car;
import com.example.RentCar.model.Client;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CarMapper {
    CarDTO toDTO(Car model);
    List<CarDTO> toDTO(List<Car> model);

    @Mapping(target = "id", ignore = true)
    Car toModel(CreateCarDTO model);

    @Mapping(target = "id", ignore = true)
    Car update(@MappingTarget Car car, UpdateCarDTO data);
}
