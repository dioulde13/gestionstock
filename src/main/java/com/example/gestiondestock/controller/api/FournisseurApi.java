package com.example.gestiondestock.controller;

import com.example.gestiondestock.dto.FournisseurDto;
import com.example.gestiondestock.model.Fournisseur;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import  static com.example.gestiondestock.utils.Constants.APP_ROOT;

public interface FournisseurApi {
    @PostMapping(value = APP_ROOT + "/fournisseur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto saveFournisseur(@RequestBody FournisseurDto dto);

    @GetMapping(value = APP_ROOT + "/fournisseur/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Fournisseur> allFournisseur();

    @GetMapping(value = APP_ROOT + "/fournisseur/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findFournisseurById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "/fournisseur/telephone/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findFournisseurTelephone(@PathVariable String telephone);

    @PutMapping(value = APP_ROOT + "/fournisseur/update/{id}")
    Optional<FournisseurDto> updateFournisseur(@RequestBody FournisseurDto dto, @PathVariable  Integer id);
}
