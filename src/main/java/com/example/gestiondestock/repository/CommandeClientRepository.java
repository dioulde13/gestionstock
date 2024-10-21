package com.example.gestiondestock.repository;

import com.example.gestiondestock.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandeClientRepository extends JpaRepository<CommandeClient,Integer> {
Optional<CommandeClient> findCommandeClientByCode(String code);
@Query("selec * from ")
CommandeClient findById(Long id);
}
