package com.example.gestiondestock.controller;

import com.example.gestiondestock.controller.api.ClientApi;
import com.example.gestiondestock.dto.ClientDto;
import com.example.gestiondestock.model.Client;
import com.example.gestiondestock.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController implements ClientApi {
    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @Override
    public ClientDto saveCLient(ClientDto dto) {
        return clientService.saveCLient(dto);
    }

    @Override
    public List<Client> getALLCLient() {
        return clientService.findAll();
    }

    @Override
    public ClientDto findClientById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public ClientDto updateCLient(ClientDto dto, Integer id) {
        return clientService.modifierClient(dto,id);
    }

    @Override
    public void deleteCLient(Integer id) {
       clientService.deleteClient(id);
    }
}
