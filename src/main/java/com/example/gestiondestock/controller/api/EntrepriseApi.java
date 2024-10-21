package com.example.gestiondestock.controller.api;

import com.example.gestiondestock.dto.EntrepriseDto;
import com.example.gestiondestock.model.Entreprise;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.gestiondestock.utils.Constants.APP_ROOT;

public interface EntrepriseApi {
    @PostMapping(value = APP_ROOT + "/entreprise/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto saveEntreprise(@RequestBody EntrepriseDto dto);

    @GetMapping(value = APP_ROOT + "/entreprise/all")
    List<Entreprise> getAllEntreprise();

    @GetMapping(value = APP_ROOT + "/entreprise/{id}")
    EntrepriseDto findByIdEntreprise(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "/entreprise/telephone/{telephone}")
    EntrepriseDto findByTelephone(@PathVariable String telephone);

    @PutMapping(value = APP_ROOT + "/entreprise/update/{id}")
    EntrepriseDto updateEntreprise(@RequestBody EntrepriseDto dto, @PathVariable Integer id);
}
