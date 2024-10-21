package com.example.gestiondestock.services;

import com.example.gestiondestock.dto.ClientDto;
import com.example.gestiondestock.model.Client;

import java.util.List;

public interface ClientService {
    ClientDto saveCLient(ClientDto dto);
    List<Client> findAll();
    ClientDto modifierClient(ClientDto dto, Integer id);
    ClientDto findById(Integer id);
    ClientDto findByTelephone(String telephone);
    void deleteClient(Integer id);
}
