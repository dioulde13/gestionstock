package com.example.gestiondestock.controller.api;

import com.example.gestiondestock.dto.AuthentificationDTO;
import com.example.gestiondestock.dto.UtilisateurDto;
import com.example.gestiondestock.model.Utilisateur;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.example.gestiondestock.utils.Constants.APP_ROOT;

public interface UtilisateurApi {
    @PostMapping(value = APP_ROOT + "/utilisateur/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto saveUtilisateur(@RequestBody UtilisateurDto dto);

    @PostMapping(value = APP_ROOT + "/utilisateur/connexion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,String> connexion(@RequestBody AuthentificationDTO authentificationDTO);

    @GetMapping(value = APP_ROOT+ "/utilisateur/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Optional<UtilisateurDto> updateUtilisateur(@RequestBody UtilisateurDto dto, @PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "/utilisateur/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Utilisateur> listUtilisateur();

    @GetMapping(value = APP_ROOT + "/utilisateur/{id}")
    UtilisateurDto findByIdUtilisateur(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "/utilisateur/telephone/{id}")
    UtilisateurDto findByTelephone(@PathVariable String telephone);
}
