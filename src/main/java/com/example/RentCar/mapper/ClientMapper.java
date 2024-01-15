package com.example.RentCar.mapper;

import com.example.RentCar.dtos.ClientDTO;
import com.example.RentCar.dtos.CreateClientDTO;
import com.example.RentCar.dtos.UpdateClientDTO;
import com.example.RentCar.model.Client;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClientMapper {
    ClientDTO toDTO(Client model);
    List<ClientDTO> toDTO(List<Client> model);

    @Mapping(target = "id", ignore = true)
    Client toModel(CreateClientDTO model);

    @Mapping(target = "id", ignore = true)
    Client update(@MappingTarget Client client, UpdateClientDTO data);
}
