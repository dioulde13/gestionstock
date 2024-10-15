package com.example.gestiondestock.dto;

import com.example.gestiondestock.model.Categorie;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class CategorieDto {

    private Integer id;

    private String codeCategorie;

    private String designation;

    private List<ArticleDto> articles;

    public static CategorieDto fromEntity(Categorie categorie) {
        if (categorie == null) {
            return null;
        }
        return CategorieDto.builder()
                .id(categorie.getId())
                .codeCategorie(categorie.getCodeCategorie())
                .designation(categorie.getDesignation())
                .articles(categorie.getArticles() != null ?
                        categorie.getArticles().stream()
                                .map(ArticleDto::fromEntity)
                                .collect(Collectors.toList()) : null)
                .build();
    }

    public static Categorie toEntity(CategorieDto categorieDto) {
        if (categorieDto == null) {
            return null;
        }
        Categorie categorie = new Categorie();
        categorie.setId(categorieDto.getId());
        categorie.setCodeCategorie(categorieDto.getCodeCategorie());
        categorie.setDesignation(categorieDto.getDesignation());
        // Pas besoin de mapper les articles ici si vous n'avez pas besoin d'une relation inverse
        return categorie;
    }
}
