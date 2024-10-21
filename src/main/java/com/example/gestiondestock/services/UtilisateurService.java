package com.example.gestiondestock.services;

import com.example.gestiondestock.dto.UtilisateurDto;
import com.example.gestiondestock.model.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService {
    UtilisateurDto saveUtilisateur(UtilisateurDto dto);
    Optional<UtilisateurDto> updateUtilisateur(UtilisateurDto dto, Integer id);
    List<Utilisateur> getAllUtilisateur();
    UtilisateurDto findByIdUtilisateur(Integer id);
    UtilisateurDto findByTelephone(String telephone);
    void deleteUtilisateur(Integer id);
}
