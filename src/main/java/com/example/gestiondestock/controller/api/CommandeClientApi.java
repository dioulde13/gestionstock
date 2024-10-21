package com.example.gestiondestock.controller.api;

import com.example.gestiondestock.dto.CommandeCLientDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.gestiondestock.utils.Constants.APP_ROOT;

public interface CommandeClientApi {

    @PostMapping(value = APP_ROOT + "/commandeClient/save")
    CommandeCLientDto saveCommandeCLient(@RequestBody CommandeCLientDto dto);

    @GetMapping(value = APP_ROOT +"/commandeCLient/all")
    List<CommandeCLientDto> getAllCommandeCLient();

    @GetMapping(value = APP_ROOT + "/commandeClient/idCLient/{id}")
    CommandeCLientDto findByIdCommandeCLient(@PathVariable  Integer id);

    @GetMapping(value = APP_ROOT + "/commandeCLient/code/{code}")
    CommandeCLientDto findByCodeCommandeClient(@PathVariable String code);

    @DeleteMapping(value = APP_ROOT + "/commandeClient/{id}")
    void  deleteCommandeCLient(@PathVariable  Integer id);
}
