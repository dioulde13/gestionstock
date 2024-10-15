package com.example.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "roles")
public class Role extends AbstractEntity{
    @Column(name = "rolename")
    private String roleName;
    @Column(name = "datecommande")
    private Date dateCommande;
    @ManyToOne
    @JoinColumn(name = "idutilisateur")
    private Utilisateur utilisateur;
}
