package com.example.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "lignecommandefournisseur")
public class LigneCommandeFournisseur extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;
    @Column(name = "datecommande")
    private Date dateCommande;
    @ManyToOne
    @JoinColumn(name = "idcommandefournisseur")
    private CommandeFournisseur commandefournisseur;
    @Column(name = "quantite")
    private  BigDecimal quantite;
    @Column(name = "prixunitaire")
    private BigDecimal prixUnitaire;
}
