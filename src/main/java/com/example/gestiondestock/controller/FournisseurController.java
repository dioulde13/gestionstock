package com.example.gestiondestock.controller;

import com.example.gestiondestock.dto.FournisseurDto;
import com.example.gestiondestock.model.Fournisseur;
import com.example.gestiondestock.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class FournisseurController implements com.example.gestiondestock.controller.FournisseurApi {
    private FournisseurService fournisseurService;

    @Autowired
    public FournisseurController(FournisseurService fournisseurService){
        this.fournisseurService = fournisseurService;
    }

    @Override
    public FournisseurDto saveFournisseur(FournisseurDto dto) {
        return fournisseurService.saveFournisseur(dto);
    }

    @Override
    public List<Fournisseur> allFournisseur() {
        return fournisseurService.listFournisseur();
    }

    @Override
    public FournisseurDto findFournisseurById(Integer id) {
        return fournisseurService.findByIdFournisseur(id);
    }

    @Override
    public FournisseurDto findFournisseurTelephone(String telephone) {
        return fournisseurService.findByTelephoneFour(telephone);
    }

    @Override
    public Optional<FournisseurDto> updateFournisseur(FournisseurDto dto, Integer id) {
        return fournisseurService.updateFournisseur(dto,id);
    }
}
