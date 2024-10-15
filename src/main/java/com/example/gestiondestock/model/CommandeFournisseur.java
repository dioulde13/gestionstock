package com.example.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "commandefournisseur")
public class CommandeFournisseur extends AbstractEntity{
   @Column(name = "code")
   private String code;
   @Column(name = "datecommande")
   private Date dateCommande;
   @Column(name = "datecommandefrs")
   private Date dateCOmmandeFrs;
   @ManyToOne
   private Fournisseur fournisseur;
}
