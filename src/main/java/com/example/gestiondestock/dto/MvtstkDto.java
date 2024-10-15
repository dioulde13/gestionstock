package com.example.gestiondestock.dto;

import com.example.gestiondestock.model.Mvstk;
import com.example.gestiondestock.model.TypeMvtStk;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
public class MvtstkDto {

    private Integer id;
    private Instant dateMvt;
    private BigDecimal quantite;
    private ArticleDto article;
    private TypeMvtStk typemvt;

    // Méthode pour convertir un MvtStk en MvtstkDto
    public static MvtstkDto fromEntity(Mvstk mvtStk) {
        if (mvtStk == null) {
            return null;
        }
        return MvtstkDto.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .quantite(mvtStk.getQuantite())
                .article(ArticleDto.fromEntity(mvtStk.getArticle()))  // Conversion de Article en ArticleDto
                .build();
    }

    // Méthode pour convertir un MvtstkDto en MvtStk
    public static Mvstk toEntity(MvtstkDto mvtstkDto) {
        if (mvtstkDto == null) {
            return null;
        }
        Mvstk mvtStk = new Mvstk();
        mvtStk.setId(mvtstkDto.getId());
        mvtStk.setDateMvt(mvtstkDto.getDateMvt());
        mvtStk.setQuantite(mvtstkDto.getQuantite());
        mvtStk.setArticle(ArticleDto.toEntity(mvtstkDto.getArticle()));  // Conversion de ArticleDto en Article
        return mvtStk;
    }
}
