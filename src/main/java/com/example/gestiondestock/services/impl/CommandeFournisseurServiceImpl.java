package com.example.gestiondestock.services.impl;

import com.example.gestiondestock.dto.CommandeFournisseurDto;
import com.example.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.example.gestiondestock.exception.EntityNotFoundException;
import com.example.gestiondestock.exception.ErrorCode;
import com.example.gestiondestock.exception.InvalideEntityException;
import com.example.gestiondestock.model.*;
import com.example.gestiondestock.repository.*;
import com.example.gestiondestock.services.CommandeFournisseurService;
import com.example.gestiondestock.validator.CommandeFournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {
    private CommandeFournisseurRepository commandeFournisseurRepository;
    private LigneCmdFournisseurRepository ligneCmdFournisseurRepository;
    private FournisseurRepository fournisseurRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public CommandeFournisseurServiceImpl(
            CommandeFournisseurRepository commandeFournisseurRepository,
            LigneCmdFournisseurRepository ligneCmdFournisseurRepository,
            FournisseurRepository fournisseurRepository,
            ArticleRepository articleRepository
    ){
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.articleRepository = articleRepository;
        this.ligneCmdFournisseurRepository = ligneCmdFournisseurRepository;
    }

    @Override
    public CommandeFournisseurDto saveCommandeFournisseur(CommandeFournisseurDto dto) {

        List<String> errors = CommandeFournisseurValidator.validate(dto);

        if (!errors.isEmpty()) {
            log.error("Commande fournisseur n'est pas valide");
            throw new InvalideEntityException("La commande fournisseur n'est pas valide", ErrorCode.COMMANDE_FOURNISSEUR_NOT_VALID, errors);
        }

        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(dto.getFournisseur().getId());

        if (fournisseur.isEmpty()) {
            log.warn("Client with {} was not found in the DB", dto.getFournisseur().getId());
            throw new EntityNotFoundException("Aucun fournisseur avec l'ID " + dto.getFournisseur().getId() + " n'a été trouvé dans la BDD", ErrorCode.FOURNISSEUR_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();

        if (dto.getLigneCommandeFournisseur() != null) {
            dto.getLigneCommandeFournisseur().forEach(ligCndClt -> {
                if (ligCndClt.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(ligCndClt.getArticle().getId());
                    if (article.isEmpty()) {
                        articleErrors.add("L'article avec l'id " + ligCndClt.getArticle().getId() + " n'existe pas");
                    }
                } else {
                    articleErrors.add("Impossible d'enregistrer une commande sans article");
                }
            });
        }

        // Changer la condition ici pour lancer l'exception si des erreurs sont présentes
        if (!articleErrors.isEmpty()) {
            log.warn("Articles non trouvés : {}", articleErrors);
            throw new InvalideEntityException("Article n'existe pas dans la BDD", ErrorCode.ARTICLE_NOT_FOUND, articleErrors);
        }

        CommandeFournisseur saveCmdFour = commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(dto));

        if (dto.getLigneCommandeFournisseur() != null) {
            dto.getLigneCommandeFournisseur().forEach(ligCmdFour -> {
                LigneCommandeFournisseur ligneCommandeClient = LigneCommandeFournisseurDto.toEntity(ligCmdFour);
                ligneCommandeClient.setCommandefournisseur(saveCmdFour);
                ligneCmdFournisseurRepository.save(ligneCommandeClient);
            });
        }
        return CommandeFournisseurDto.fromEntity(saveCmdFour);
    }


    @Override
    public CommandeFournisseurDto findByIdCommandeFournisseur(Integer id) {
        if(id == null){
            log.error("Commande client ID is NULL");
            return null;
        }
        return commandeFournisseurRepository.findById(id).map(
                CommandeFournisseurDto::fromEntity
        ).orElseThrow(()-> new EntityNotFoundException("Aucune commande fournisseur n'a ete trouve avec l'id "+ id,ErrorCode.COMMANDE_FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public CommandeFournisseurDto findByCodeCommandeFournisseur(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("Commande client code is null");
            return null;
        }
        return commandeFournisseurRepository.findCommandeFournisseurByCode(code).map(
                CommandeFournisseurDto::fromEntity
        ).orElseThrow(()-> new EntityNotFoundException("Aucune commande fournisseur n'a ete trouve avec l ecode "+ code,ErrorCode.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public List<CommandeFournisseurDto> findAllCommandeFournisseur() {
        return commandeFournisseurRepository.findAll().stream()
                .map(CommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCommandeFournisseur(Integer id) {
        if(id == null){
            log.error("Commande fournisseur ID is null");
            return;
        }
        commandeFournisseurRepository.deleteById(id);
    }
}
