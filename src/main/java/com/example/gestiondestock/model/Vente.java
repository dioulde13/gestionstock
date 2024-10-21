package com.example.gestiondestock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "vente")
public class Vente extends AbstractEntity{

    @OneToMany(mappedBy = "vente")
    private List<LigneDeVente> ligneDeVente;
    @Column(name = "code")
    private String code;
    @Column(name = "datecommande")
    private Date dateCommande;
    @Column(name = "datevente")
    private Date dateVente;
    @Column(name = "commentaire")
    private String commentaire;
}
