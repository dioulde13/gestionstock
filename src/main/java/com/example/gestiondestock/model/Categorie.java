package com.example.gestiondestock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "categorie")
public class Categorie extends AbstractEntity {

    @Column(name = "codeCategorie")
    private String codeCategorie;
    @Column(name = "designation")
    private  String designation;
    @Column(name = "identreprise")
    private Integer idEntreprise;
    @OneToMany(mappedBy = "categorie")
    private List<Article> articles;
}
