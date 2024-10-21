package com.example.gestiondestock.controller;

import com.example.gestiondestock.controller.api.VenteApi;
import com.example.gestiondestock.dto.VenteDto;
import com.example.gestiondestock.model.Vente;
import com.example.gestiondestock.services.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class VenteController implements VenteApi {
    private VenteService venteService;

    @Autowired
    public VenteController(VenteService venteService){
        this.venteService = venteService;
    }

    @Override
    public VenteDto createVente(VenteDto dto) {
        return venteService.createVente(dto);
    }

    @Override
    public List<Vente> allVente() {
        return venteService.listTotalVente();
    }

    @Override
    public VenteDto findByIdVente(Integer id) {
        return venteService.findByIdVente(id);
    }

    @Override
    public Optional<VenteDto> updateVente(VenteDto dto, Integer id) {
        return venteService.updateVente(dto,id);
    }

    @Override
    public void deleteVente(Integer id) {
      venteService.deleteVente(id);
    }
}
