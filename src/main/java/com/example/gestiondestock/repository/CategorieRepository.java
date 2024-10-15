package com.example.gestiondestock.repository;

import com.example.gestiondestock.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
    Optional<Categorie> findByCodeCategorie(String codeCategorie);
}

