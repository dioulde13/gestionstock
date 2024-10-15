package com.example.gestiondestock.repository;

import com.example.gestiondestock.model.LigneDeVente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneVenteRepository extends JpaRepository<LigneDeVente,Integer> {
}
