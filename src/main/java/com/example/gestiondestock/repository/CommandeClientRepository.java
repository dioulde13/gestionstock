package com.example.gestiondestock.repository;

import com.example.gestiondestock.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeClientRepository extends JpaRepository<CommandeClient,Integer> {
}
