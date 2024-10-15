package com.example.gestiondestock.dto;

import com.example.gestiondestock.model.CommandeFournisseur;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class CommandeFournisseurDto {

    private Integer id;
    private String code;
    private Date dateCommandeFrs;
    private FournisseurDto fournisseur;

    // Méthode pour convertir un CommandeFournisseur en CommandeFournisseurDto
    public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur) {
        if (commandeFournisseur == null) {
            return null;
        }
        return CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .build();
    }

    // Méthode pour convertir un CommandeFournisseurDto en CommandeFournisseur
    public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto) {
        if (commandeFournisseurDto == null) {
            return null;
        }
        CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
        commandeFournisseur.setId(commandeFournisseurDto.getId());
        commandeFournisseur.setCode(commandeFournisseurDto.getCode());
        return commandeFournisseur;
    }
}
