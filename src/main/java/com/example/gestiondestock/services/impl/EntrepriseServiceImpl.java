package com.example.gestiondestock.services.impl;

import com.example.gestiondestock.dto.EntrepriseDto;
import com.example.gestiondestock.exception.EntityNotFoundException;
import com.example.gestiondestock.model.Entreprise;
import com.example.gestiondestock.repository.EntrepriseRepository;
import com.example.gestiondestock.services.EntrepriseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EntrepriseServiceImpl implements EntrepriseService {
    private EntrepriseRepository entrepriseRepository;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository){
        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public EntrepriseDto saveEntreprise(EntrepriseDto dto) {
        Entreprise saveEntreprise = entrepriseRepository.save(EntrepriseDto.toEntity(dto));
        return EntrepriseDto.fromEntity(saveEntreprise);
    }

    @Override
    public List<Entreprise> listALLEntreprise() {
        return entrepriseRepository.findAll();
    }

    @Override
    public EntrepriseDto findByIdEntreprise(Integer id) {
        Optional<Entreprise> findById = entrepriseRepository.findById(id);
        return findById.map(EntrepriseDto::fromEntity).orElseThrow(
                () -> new EntityNotFoundException("l'entreprise de "+ id +" n'a pas ete trouver")
        );
    }

    @Override
    public EntrepriseDto findByTelephoneEntreprise(String telephone) {
        Optional<Entreprise> findByTelephone = entrepriseRepository.findEntrepriseByTelephone(telephone);
        return findByTelephone.map(EntrepriseDto::fromEntity).orElseThrow(
                ()->new EntityNotFoundException("l'entreprise avec le telephone " +telephone+" n'a pas ete trouver")
        );
    }

    @Override
    public EntrepriseDto updateEntreprise(EntrepriseDto dto, Integer id) {
        return entrepriseRepository.findById(id).map(
                p->{
                    p.setNom(dto.getNom());
                    p.setPrenom(dto.getPrenom());
                    p.setEmail(dto.getEmail());
                    p.setTelephone(dto.getTelephone());
                    Entreprise updateEntreprise = entrepriseRepository.save(p);
                    return EntrepriseDto.fromEntity(updateEntreprise);
                }
        ).orElseThrow(
                ()->new EntityNotFoundException("l'entreprise avec cet id n'existe pas")
        );
    }

    @Override
    public void deleteEntreprise(Integer id) {
        if(id == null){
            log.error("L'id n'existe pas");
        }
     entrepriseRepository.deleteById(id);
    }
}
