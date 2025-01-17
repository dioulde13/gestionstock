package com.example.gestiondestock.dto;

import com.example.gestiondestock.model.Article;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ArticleDto {

    private Integer id;

    private String codeArticle;

    private String designation;

    private Integer idEntreprise;

    public static ArticleDto fromEntity(Article article) {
        if (article == null) {
            return null;
        }
        return ArticleDto.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .designation(article.getDesignation())
                .idEntreprise(article.getIdEntreprise())
                .build();
    }

    public static Article toEntity(ArticleDto articleDto) {
        if (articleDto == null) {
            return null;
        }
        Article article = new Article();
        article.setId(articleDto.getId());
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setIdEntreprise(articleDto.getIdEntreprise());
        article.setDesignation(articleDto.getDesignation());
        return article;
    }
}
