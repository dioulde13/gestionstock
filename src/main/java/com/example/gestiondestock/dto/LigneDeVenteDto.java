package com.example.gestiondestock.dto;

import com.example.gestiondestock.model.LigneDeVente;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LigneDeVenteDto {

    private Integer id;
    private ArticleDto article;
    private VenteDto vente;
    private String code;
    private BigDecimal quantite;
    private Integer idEntreprise;
    private BigDecimal prixUnitaire;

    // Méthode pour convertir un LigneDeVente en LigneDeVenteDto
    public static LigneDeVenteDto fromEntity(LigneDeVente ligneDeVente) {
        if (ligneDeVente == null) {
            return null;
        }
        return LigneDeVenteDto.builder()
                .id(ligneDeVente.getId())
                .article(ArticleDto.fromEntity(ligneDeVente.getArticle()))  // Conversion de Article en ArticleDto
                .code(ligneDeVente.getCode())
                .quantite(ligneDeVente.getQuantite())
                .prixUnitaire(ligneDeVente.getPrixUnitaire())
                .build();
    }

    // Méthode pour convertir un LigneDeVenteDto en LigneDeVente
    public static LigneDeVente toEntity(LigneDeVenteDto ligneDeVenteDto) {
        if (ligneDeVenteDto == null) {
            return null;
        }
        LigneDeVente ligneDeVente = new LigneDeVente();
        ligneDeVente.setId(ligneDeVenteDto.getId());
        ligneDeVente.setArticle(ArticleDto.toEntity(ligneDeVenteDto.getArticle()));  // Conversion de ArticleDto en Article
        ligneDeVente.setCode(ligneDeVenteDto.getCode());
        ligneDeVente.setQuantite(ligneDeVenteDto.getQuantite());
        ligneDeVente.setPrixUnitaire(ligneDeVenteDto.getPrixUnitaire());
        return ligneDeVente;
    }
}
