package com.example.gestiondestock.services.impl;

import com.example.gestiondestock.dto.LigneDeVenteDto;
import com.example.gestiondestock.dto.VenteDto;
import com.example.gestiondestock.exception.EntityNotFoundException;
import com.example.gestiondestock.exception.ErrorCode;
import com.example.gestiondestock.exception.InvalideEntityException;
import com.example.gestiondestock.model.Article;
import com.example.gestiondestock.model.LigneDeVente;
import com.example.gestiondestock.model.Vente;
import com.example.gestiondestock.repository.ArticleRepository;
import com.example.gestiondestock.repository.LigneVenteRepository;
import com.example.gestiondestock.repository.VenteRepository;
import com.example.gestiondestock.services.VenteService;
import com.example.gestiondestock.validator.VenteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class VenteServiceImpl implements VenteService {
    private VenteRepository venteRepository;
    private ArticleRepository articleRepository;
    private LigneVenteRepository ligneVenteRepository;

    @Autowired
    public VenteServiceImpl(VenteRepository venteRepository){
        this.venteRepository = venteRepository;
        this.articleRepository = articleRepository;
        this.ligneVenteRepository = ligneVenteRepository;
    }

    @Override
    public VenteDto createVente(VenteDto dto) {
        List<String>  errors = VenteValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Vente n'est pas valide");
            throw new InvalideEntityException("", ErrorCode.VENTE_NOT_VALID, errors);
        }
       List<String> articleErrors = new ArrayList<>();
        dto.getLigneDeVente().forEach(ligneDeVenteDto -> {
            Optional<Article> article = articleRepository.findById(ligneDeVenteDto.getArticle().getId());
         if(article.isEmpty()){
             articleErrors.add("Aucun artricle avec l'ID"+ligneDeVenteDto.getArticle().getId()+" n'a ete trouver dans la BDD");
         }
        });

        if(!articleErrors.isEmpty()){
            log.error("One or more article", errors);
            throw new InvalideEntityException("un ou plusieurs articles n'ont pas ete trouver dans la BDD", ErrorCode.VENTE_NOT_VALID, errors);
        }
        Vente saveVente = venteRepository.save(VenteDto.toEntity(dto));
        dto.getLigneDeVente().forEach(ligneDeVenteDto -> {
            LigneDeVente ligneDeVente = LigneDeVenteDto.toEntity(ligneDeVenteDto);
            ligneVenteRepository.save(ligneDeVente);
        });
        return VenteDto.fromEntity(saveVente);
    }

    @Override
    public List<Vente> listTotalVente() {
        return venteRepository.findAll();
    }

    @Override
    public Optional<VenteDto> updateVente(VenteDto dto, Integer id) {
        return venteRepository.findById(id).map(
                vente -> {
                    vente.setId(dto.getId());
                    vente.setCode(dto.getCode());
                    vente.setDateVente(dto.getDateVente());
                    vente.setCommentaire(dto.getCommentaire());
//                    vente.setLigneDeVenteList(dto.getLigneDeVenteList());
                    Vente updateVente = venteRepository.save(vente);
                    return VenteDto.fromEntity(updateVente);
                }
        );
    }

    @Override
    public VenteDto findByIdVente(Integer id) {
        Optional<Vente> findById = venteRepository.findById(id);
        return findById.map(VenteDto::fromEntity).orElseThrow(
                ()->new EntityNotFoundException("L'id vente n'existe pas")
        );
    }

    @Override
    public void deleteVente(Integer id) {
        if(id == null){
            log.error("L'id n'a pas ete trouver");
            return;
        }
      venteRepository.findById(id);
    }
}
