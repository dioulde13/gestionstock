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
@Table(name = "commandeclient")
public class CommandeClient extends AbstractEntity{

    @Column(name = "code")
    private String code;
    @Column(name = "identreprise")
    private Integer idEntreprise;
    @Column(name = "datecommande")
    private Date dateCommande;
    @ManyToOne
    @JoinColumn(name = "idclient")
    private Client client;
    @OneToMany(mappedBy = "commandeclient")
    private List<LigneCommandeClient> ligneCommandeClients;
}
