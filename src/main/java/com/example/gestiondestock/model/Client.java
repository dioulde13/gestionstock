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
@Table(name = "client")
public class Client extends AbstractEntity{

    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "adresse")
    @Embedded
    private Adresse adresse;
    @Column(name = "photo")
    private String photo;
    @Column(name = "email")
    private String email;
    @Column(name = "identreprise")
    private Integer idEntreprise;
    @Column(name = "telephone")
    private String telephone;
    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeclient;
}
