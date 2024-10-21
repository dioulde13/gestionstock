package com.example.gestiondestock.controller;

import com.example.gestiondestock.controller.api.CommandeClientApi;
import com.example.gestiondestock.dto.CommandeCLientDto;
import com.example.gestiondestock.services.CommandeClientService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommandeCLientController implements CommandeClientApi {
    private CommandeClientService commandeClientService;

    public CommandeCLientController(CommandeClientService commandeClientService){
        this.commandeClientService = commandeClientService;
    }

    @Override
    public CommandeCLientDto saveCommandeCLient(CommandeCLientDto commandeCLientDto) {
        return commandeClientService.saveCommandeClient(commandeCLientDto);
    }

    @Override
    public List<CommandeCLientDto> getAllCommandeCLient() {
        return commandeClientService.findAllCommandeCLient();
    }

    @Override
    public CommandeCLientDto findByIdCommandeCLient(Integer id) {
        return commandeClientService.findByIdCommandeClient(id);
    }

    @Override
    public CommandeCLientDto findByCodeCommandeClient(String code) {
        return commandeClientService.findByCodeCommandeCLient(code);
    }

    @Override
    public void deleteCommandeCLient(Integer id) {
        commandeClientService.deleteCommandeCLient(id);
    }
}
