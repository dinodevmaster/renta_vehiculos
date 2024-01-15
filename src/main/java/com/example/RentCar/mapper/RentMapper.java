package com.example.RentCar.mapper;

import com.example.RentCar.dtos.ClientDTO;
import com.example.RentCar.dtos.CreateRentDTO;
import com.example.RentCar.dtos.RentDTO;
import com.example.RentCar.model.Client;
import com.example.RentCar.model.Rent;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RentMapper {

    RentDTO toDTO(Rent model);

    @Mapping(target="id", ignore = true)
    Rent toModel(CreateRentDTO model);
}
