package com.example.gestiondestock.services;

import com.example.gestiondestock.dto.CommandeCLientDto;
import com.example.gestiondestock.dto.CommandeFournisseurDto;

import java.util.List;

public interface CommandeFournisseurService {
    CommandeFournisseurDto saveCommandeFournisseur(CommandeFournisseurDto dto);

    CommandeFournisseurDto findByIdCommandeFournisseur(Integer id);

    CommandeFournisseurDto findByCodeCommandeFournisseur(String code);

    List<CommandeFournisseurDto> findAllCommandeFournisseur();

    void deleteCommandeFournisseur(Integer id);

}
