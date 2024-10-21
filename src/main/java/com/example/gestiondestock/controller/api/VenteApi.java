package com.example.gestiondestock.controller.api;

import com.example.gestiondestock.dto.VenteDto;
import com.example.gestiondestock.model.Vente;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.gestiondestock.utils.Constants.APP_ROOT;
public interface VenteApi {
    @PostMapping(value = APP_ROOT + "/vente/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VenteDto createVente(@RequestBody VenteDto dto);

    @GetMapping(value = APP_ROOT + "/vente/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Vente> allVente();

    @GetMapping(value = APP_ROOT + "/vente/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    VenteDto findByIdVente(@PathVariable Integer id);

    @PutMapping(value = APP_ROOT + "/vente/update/{id}")
    Optional<VenteDto> updateVente(@RequestBody VenteDto dto, @PathVariable Integer id);

    @DeleteMapping(value = APP_ROOT + "/vente/delete/{id}")
    void deleteVente(@PathVariable Integer id);
}

