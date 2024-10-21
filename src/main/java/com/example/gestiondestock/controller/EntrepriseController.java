package com.example.gestiondestock.controller;

import com.example.gestiondestock.controller.api.EntrepriseApi;
import com.example.gestiondestock.dto.EntrepriseDto;
import com.example.gestiondestock.model.Entreprise;
import com.example.gestiondestock.services.EntrepriseService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntrepriseController implements EntrepriseApi {
    private EntrepriseService entrepriseService;

    public EntrepriseController(EntrepriseService entrepriseService){
        this.entrepriseService = entrepriseService;
    }

    @Override
    public EntrepriseDto saveEntreprise(EntrepriseDto dto) {
        return entrepriseService.saveEntreprise(dto);
    }

    @Override
    public List<Entreprise> getAllEntreprise() {
        return entrepriseService.listALLEntreprise();
    }

    @Override
    public EntrepriseDto findByIdEntreprise(Integer id) {
        return entrepriseService.findByIdEntreprise(id);
    }

    @Override
    public EntrepriseDto findByTelephone(String telephone) {
        return entrepriseService.findByTelephoneEntreprise(telephone);
    }

    @Override
    public EntrepriseDto updateEntreprise(EntrepriseDto dto, Integer id) {
        return entrepriseService.updateEntreprise(dto,id);
    }
}
