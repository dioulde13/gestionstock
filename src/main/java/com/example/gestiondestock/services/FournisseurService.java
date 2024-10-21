package com.example.gestiondestock.services;

import com.example.gestiondestock.dto.FournisseurDto;
import com.example.gestiondestock.model.Fournisseur;

import java.util.List;
import java.util.Optional;

public interface FournisseurService {
    FournisseurDto saveFournisseur(FournisseurDto dto);
    Optional<FournisseurDto> updateFournisseur(FournisseurDto dto, Integer id);
    List<Fournisseur> listFournisseur();
    FournisseurDto findByIdFournisseur(Integer id);
    FournisseurDto findByTelephoneFour(String telephone);
    void deleteFournisseur(Integer id);
}
