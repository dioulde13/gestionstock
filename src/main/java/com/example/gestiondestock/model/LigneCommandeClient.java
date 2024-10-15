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
@Table(name = "lignecommadeclient")
public class LigneCommandeClient  extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "idcommandeclient")
    private  CommandeClient commandeclient;
    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;
    @Column(name = "datecommande")
    private Date dateCommande;
    @Column(name = "quantite")
    private BigDecimal quantite;
    @Column(name = "prixunitaire")
    private BigDecimal prixUnitaire;
}
