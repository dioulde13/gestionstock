package com.example.gestiondestock.repository;

import com.example.gestiondestock.model.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCmdClientRepository extends JpaRepository<LigneCommandeClient,Integer> {
}
