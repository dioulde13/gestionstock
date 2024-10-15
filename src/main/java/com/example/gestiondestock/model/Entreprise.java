package com.example.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "entreprise")
public class Entreprise extends AbstractEntity{

    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    @Embedded
    private Adresse adresse;
    private String prenom;
    @Column(name = "photo")
    private String photo;
    @Column(name = "email")
    private String email;
    @Column(name = "telephone")
    private String telephone;
    @OneToMany(mappedBy = "entreprise")
    private List<Utilisateur> utilisateurList;
}
