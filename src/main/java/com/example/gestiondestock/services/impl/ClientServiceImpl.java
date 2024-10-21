package com.example.gestiondestock.services.impl;

import com.example.gestiondestock.dto.ClientDto;
import com.example.gestiondestock.exception.EntityNotFoundException;
import com.example.gestiondestock.model.Client;
import com.example.gestiondestock.repository.ClientRepository;
import com.example.gestiondestock.services.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto saveCLient(ClientDto dto) {
        Client enregistrerClient = clientRepository.save(ClientDto.toEntity(dto));
        return ClientDto.fromEntity(enregistrerClient);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public ClientDto modifierClient(ClientDto dto, Integer id) {
        return clientRepository.findById(id).map(
                client -> {
                    client.setNom(dto.getNom());
                    client.setPrenom(dto.getPrenom());
//                    client.setAdresse(dto.getAdresse());
                    client.setEmail(dto.getEmail());
                    client.setTelephone(dto.getTelephone());
                    Client updatedClient = clientRepository.save(client);
                    return ClientDto.fromEntity(updatedClient);
                }
        ).orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + id));
    }

    @Override
    public ClientDto findById(Integer id) {
      Optional<Client> findById = clientRepository.findById(id);
      return findById.map(ClientDto::fromEntity)
              .orElseThrow(() -> new EntityNotFoundException("Client with ID " + id + " not found"));
    }

    @Override
    public ClientDto findByTelephone(String telephone) {
        Optional<Client> findByTelephone = clientRepository.findByTelephone(telephone);
        return findByTelephone.map(ClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Client with ID " + telephone + " not found"));
    }

    @Override
    public void deleteClient(Integer id) {
      if(id == null){
          log.error("L'id ne doit pas etre null");
          return;
      }
      clientRepository.deleteById(id);
    }
}
