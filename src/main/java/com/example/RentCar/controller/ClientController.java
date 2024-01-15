package com.example.RentCar.controller;

import com.example.RentCar.dtos.ClientDTO;
import com.example.RentCar.dtos.CreateClientDTO;
import com.example.RentCar.dtos.UpdateClientDTO;
import com.example.RentCar.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDTO> getClients(){
        return clientService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTO createClient(@Valid @RequestBody CreateClientDTO data){
        return clientService.createClient(data);
    }

    @PutMapping("{clientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateClient(@PathVariable long clientId, @Valid @RequestBody UpdateClientDTO data){
        clientService.updateClient(clientId, data);
    }

    @DeleteMapping("{clientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable long clientId){
        clientService.deleteClient(clientId);
    }
}
