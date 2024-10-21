package com.example.gestiondestock.services;

import com.example.gestiondestock.dto.EntrepriseDto;
import com.example.gestiondestock.model.Entreprise;

import java.util.List;

public interface EntrepriseService {
    EntrepriseDto saveEntreprise(EntrepriseDto dto);
    List<Entreprise> listALLEntreprise();
    EntrepriseDto findByIdEntreprise(Integer id);
    EntrepriseDto findByTelephoneEntreprise(String telephone);
    EntrepriseDto updateEntreprise(EntrepriseDto dto, Integer id);
    void deleteEntreprise(Integer id);
}
