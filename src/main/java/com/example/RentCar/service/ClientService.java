package com.example.RentCar.service;

import com.example.RentCar.dtos.ClientDTO;
import com.example.RentCar.dtos.CreateClientDTO;
import com.example.RentCar.dtos.UpdateClientDTO;
import com.example.RentCar.mapper.ClientMapper;
import com.example.RentCar.model.Client;
import com.example.RentCar.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    public List<ClientDTO> getAll(){
        return clientMapper.toDTO(clientRepository.findAll());
    }

    public ClientDTO createClient(CreateClientDTO data){
        return clientMapper.toDTO(clientRepository.save(clientMapper.toModel(data)));
    }

    public void updateClient(long clientId, UpdateClientDTO data){
        Optional<Client> row = clientRepository.findById(clientId);
        Client client = row.get();
        clientMapper.update(client,data);
        clientRepository.save(client);
    }

    public void deleteClient(long clientId){
        Optional<Client> row = clientRepository.findById(clientId);
        Client client = row.get();
        clientRepository.delete(client);
    }
}
