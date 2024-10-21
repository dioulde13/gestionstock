package com.example.gestiondestock.services.impl;

import com.example.gestiondestock.dto.FournisseurDto;
import com.example.gestiondestock.exception.EntityNotFoundException;
import com.example.gestiondestock.model.Fournisseur;
import com.example.gestiondestock.repository.FournisseurRepository;
import com.example.gestiondestock.services.FournisseurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class FournisseurServiceImpl implements FournisseurService {
    private FournisseurRepository fournisseurRepository;

    @Autowired
    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository){
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public FournisseurDto saveFournisseur(FournisseurDto dto) {
        Fournisseur saveFournisseur = fournisseurRepository.save(FournisseurDto.toEntity(dto));
        return FournisseurDto.fromEntity(saveFournisseur);
    }

    @Override
    public Optional<FournisseurDto> updateFournisseur(FournisseurDto dto, Integer id) {
        return fournisseurRepository.findById(id).map(
                fournisseur -> {
                    fournisseur.setNom(dto.getNom());
                    fournisseur.setPrenom(dto.getPrenom());
                    fournisseur.setEmail(dto.getEmail());
                    fournisseur.setTelephone(dto.getTelephone());
                    Fournisseur saveFournisseur = fournisseurRepository.save(fournisseur);
                    return FournisseurDto.fromEntity(saveFournisseur);
                }
        );
    }

    @Override
    public List<Fournisseur> listFournisseur() {
        return fournisseurRepository.findAll();
    }

    @Override
    public FournisseurDto findByIdFournisseur(Integer id) {
        Optional<Fournisseur> findById = fournisseurRepository.findById(id);
        return findById.map(FournisseurDto::fromEntity).orElseThrow(
                ()-> new EntityNotFoundException("l'id n'a pas ete trouver")
        );
    }

    @Override
    public FournisseurDto findByTelephoneFour(String telephone) {
        Optional<Fournisseur> findByTelephoneFour = fournisseurRepository.findByTelephone(telephone);
        return findByTelephoneFour.map(FournisseurDto::fromEntity).orElseThrow(
                ()-> new EntityNotFoundException("le telephone n'a pas ete trouver")
        );
    }

    @Override
    public void deleteFournisseur(Integer id) {
        if(id == null){
            log.error("L'id n'a pas ete trouver");
            return;
        }
        fournisseurRepository.deleteById(id);
    }
}
