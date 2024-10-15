package com.example.gestiondestock.dto;

import com.example.gestiondestock.model.Vente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
@Data
public class VenteDto {

    private Integer id;
    @JsonIgnore
    private List<LigneDeVenteDto> ligneDeVenteList;
    private String code;
    private Date dateVente;
    private String commentaire;

    // Méthode pour convertir une entité Vente en VenteDto
    public static VenteDto fromEntity(Vente vente) {
        if (vente == null) {
            return null;
        }
        return VenteDto.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .dateVente(vente.getDateVente())
                .commentaire(vente.getCommentaire())
                .build();
    }

    // Méthode pour convertir un DTO VenteDto en entité Vente
    public static Vente toEntity(VenteDto venteDto) {
        if (venteDto == null) {
            return null;
        }
        Vente vente = new Vente();
        vente.setId(venteDto.getId());
        vente.setCode(venteDto.getCode());
        vente.setDateVente(venteDto.getDateVente());
        vente.setCommentaire(venteDto.getCommentaire());
        return vente;
    }
}
