package com.example.gestiondestock.repository;

import com.example.gestiondestock.model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenteRepository extends JpaRepository<Vente,Integer> {
}
