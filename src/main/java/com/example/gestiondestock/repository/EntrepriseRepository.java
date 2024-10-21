package com.example.gestiondestock.repository;

import com.example.gestiondestock.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer> {
    public Optional<Entreprise> findEntrepriseByTelephone(String telephone);
}
