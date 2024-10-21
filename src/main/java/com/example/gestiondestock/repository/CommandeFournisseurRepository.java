package com.example.gestiondestock.repository;

import com.example.gestiondestock.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur,Integer> {
Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);
}
