package com.example.gestiondestock.repository;

import com.example.gestiondestock.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Integer> {
    public Optional<Fournisseur> findByTelephone(String telephone);
}
