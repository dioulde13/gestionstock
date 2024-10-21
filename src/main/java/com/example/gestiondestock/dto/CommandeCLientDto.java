package com.example.gestiondestock.dto;

import com.example.gestiondestock.model.CommandeClient;
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

    private ClientDto client;

    private Integer idEntreprise;

    private List<LigneCommandeClientDto> ligneCommandeClients;

    // Méthode pour convertir un CommandeClient en CommandeCLientDto
//    public static CommandeCLientDto fromEntity(CommandeClient commandeClient) {
//        if (commandeClient == null) {
//            return null;
//        }
//        return CommandeCLientDto.builder()
//                .id(commandeClient.getId())
//                .code(commandeClient.getCode())
//                .dateCommande(commandeClient.getDateCommande())
//                .idEntreprise(commandeClient.getIdEntreprise())
//                .client(ClientDto.fromEntity(commandeClient.getClient()))  // Conversion de Client en ClientDto
//                .ligneCommandeClients(commandeClient.getLigneCommandeClients().stream()
//                        .map(LigneCommandeClientDto::fromEntity) // Conversion des lignes de commande
//                        .collect(Collectors.toList())) // Collecte dans une liste
//                .build();
//    }

    public static CommandeCLientDto fromEntity(CommandeClient commandeClient) {
        if (commandeClient == null) {
            return null;
        }
        return CommandeCLientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .idEntreprise(commandeClient.getIdEntreprise())  // Assurez-vous que cette valeur est assignée correctement
                .client(ClientDto.fromEntity(commandeClient.getClient()))  // Conversion de Client en ClientDto
                .ligneCommandeClients(commandeClient.getLigneCommandeClients().stream()
                        .map(LigneCommandeClientDto::fromEntity)  // Conversion des lignes de commande
                        .collect(Collectors.toList()))  // Collecte dans une liste
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
        commandeClient.setIdEntreprise(commandeCLientDto.getIdEntreprise());
        commandeClient.setClient(ClientDto.toEntity(commandeCLientDto.getClient()));  // Conversion de ClientDto en Client
        commandeClient.setLigneCommandeClients(commandeCLientDto.getLigneCommandeClients().stream()
                .map(LigneCommandeClientDto::toEntity) // Conversion des lignes de commande
                .collect(Collectors.toList())); // Collecte dans une liste
        return commandeClient;
    }
}
