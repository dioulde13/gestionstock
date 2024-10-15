package com.example.gestiondestock.dto;

import com.example.gestiondestock.model.CommandeClient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class CommandeCLientDto {

    private Integer id;
    private String code;
    private Date dateCommande;
    private ClientDto client;  // Utilisation de ClientDto au lieu de Client
    @JsonIgnore
    private List<LigneCommandeClientDto> ligneCommandeClients;

    // Méthode pour convertir un CommandeClient en CommandeCLientDto
    public static CommandeCLientDto fromEntity(CommandeClient commandeClient) {
        if (commandeClient == null) {
            return null;
        }
        return CommandeCLientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .client(ClientDto.fromEntity(commandeClient.getClient()))  // Conversion de Client en ClientDto
                .build();
    }

    // Méthode pour convertir un CommandeCLientDto en CommandeClient
    public static CommandeClient toEntity(CommandeCLientDto commandeCLientDto) {
        if (commandeCLientDto == null) {
            return null;
        }
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(commandeCLientDto.getId());
        commandeClient.setCode(commandeCLientDto.getCode());
        commandeClient.setDateCommande(commandeCLientDto.getDateCommande());
        commandeClient.setClient(ClientDto.toEntity(commandeCLientDto.getClient()));  // Conversion de ClientDto en Client
        return commandeClient;
    }
}
