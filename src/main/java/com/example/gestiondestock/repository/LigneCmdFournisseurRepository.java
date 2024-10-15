package com.example.gestiondestock.repository;

import com.example.gestiondestock.model.LigneCommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCmdFournisseurRepository extends JpaRepository<LigneCommandeFournisseur,Integer> {
}
