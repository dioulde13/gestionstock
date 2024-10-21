package com.example.gestiondestock.services;

import com.example.gestiondestock.dto.VenteDto;
import com.example.gestiondestock.model.Vente;

import java.util.List;
import java.util.Optional;

public interface VenteService {
    VenteDto createVente(VenteDto dto);
    List<Vente> listTotalVente();
    Optional<VenteDto> updateVente(VenteDto dto, Integer id);
    VenteDto findByIdVente(Integer id);
    void deleteVente(Integer id);
}
