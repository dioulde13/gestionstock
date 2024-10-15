package com.example.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "utilisateur")
public class Utilisateur extends AbstractEntity{

    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Embedded
    private Adresse adresse;
    @Column(name = "photo")
    private String photo;
    @Column(name = "email")
    private String email;
    @Column(name = "telephone")
    private String telephone;
    @ManyToOne
    @JoinColumn(name = "identreprise")
    private Entreprise entreprise;
    @OneToMany(mappedBy = "utilisateur")
    private List<Role> rolelist;
}
