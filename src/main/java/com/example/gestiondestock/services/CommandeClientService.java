package com.example.gestiondestock.services;

import com.example.gestiondestock.dto.CommandeCLientDto;
import com.example.gestiondestock.model.CommandeClient;

import java.util.List;

public interface CommandeClientService {
    CommandeCLientDto saveCommandeClient(CommandeCLientDto dto);

    CommandeCLientDto findByIdCommandeClient(Integer id);

    CommandeCLientDto findByCodeCommandeCLient(String code);

    List<CommandeCLientDto> findAllCommandeCLient();

    void deleteCommandeCLient(Integer id);
}
