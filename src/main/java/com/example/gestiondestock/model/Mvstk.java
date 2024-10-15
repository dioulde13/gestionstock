package com.example.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "mvstk")
public class Mvstk  extends AbstractEntity{
    @Column(name = "datemvt")
    private Instant dateMvt;
    @Column(name = "datecommande")
    private Date dateCommande;
    @Column(name = "quantite")
    private BigDecimal quantite;
    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;
    @Column(name = "typemvt")
    private TypeMvtStk typemvt;
}
