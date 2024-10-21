package com.example.gestiondestock.controller.api;

import com.example.gestiondestock.dto.ClientDto;
import com.example.gestiondestock.model.Client;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.gestiondestock.utils.Constants.APP_ROOT;

public interface ClientApi {

    @PostMapping(value = APP_ROOT + "/client/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto saveCLient(@RequestBody ClientDto dto);

    @GetMapping(value = APP_ROOT + "/client/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Client> getALLCLient();

    @GetMapping(value = APP_ROOT + "/client/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findClientById(@PathVariable Integer id);

    @PutMapping(value = APP_ROOT + "/client/update/{id}")
    ClientDto updateCLient(@RequestBody ClientDto dto , @PathVariable Integer id);

    @DeleteMapping(value = APP_ROOT + "/client/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteCLient(@PathVariable Integer id);
}
