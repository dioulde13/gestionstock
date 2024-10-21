package com.example.gestiondestock.services.impl;

import com.example.gestiondestock.dto.CommandeCLientDto;
import com.example.gestiondestock.dto.LigneCommandeClientDto;
import com.example.gestiondestock.exception.EntityNotFoundException;
import com.example.gestiondestock.exception.ErrorCode;
import com.example.gestiondestock.exception.InvalideEntityException;
import com.example.gestiondestock.model.Article;
import com.example.gestiondestock.model.Client;
import com.example.gestiondestock.model.CommandeClient;
import com.example.gestiondestock.model.LigneCommandeClient;
import com.example.gestiondestock.repository.ArticleRepository;
import com.example.gestiondestock.repository.ClientRepository;
import com.example.gestiondestock.repository.CommandeClientRepository;
import com.example.gestiondestock.repository.LigneCmdClientRepository;
import com.example.gestiondestock.services.CommandeClientService;
import com.example.gestiondestock.validator.CommandeCLientValidator;
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
public class CommandeCLientServiceImpl implements CommandeClientService {
    private CommandeClientRepository commandeClientRepository;
    private LigneCmdClientRepository ligneCmdClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public CommandeCLientServiceImpl(
            CommandeClientRepository commandeClientRepository,
            ClientRepository clientRepository,
            ArticleRepository articleRepository,
            LigneCmdClientRepository ligneCmdClientRepository
    ){
      this.commandeClientRepository = commandeClientRepository;
      this.clientRepository = clientRepository;
      this.articleRepository = articleRepository;
      this.ligneCmdClientRepository = ligneCmdClientRepository;
    }

    @Override
    public CommandeCLientDto saveCommandeClient(CommandeCLientDto dto) {

        List<String> errors = CommandeCLientValidator.validate(dto);

        if (!errors.isEmpty()) {
            log.error("Commande client n'est pas valide");
            throw new InvalideEntityException("La commande client n'est pas valide", ErrorCode.COMMANDE_CLIENT_NOT_VALID, errors);
        }

        Optional<Client> client = clientRepository.findById(dto.getClient().getId());

        if (client.isEmpty()) {
            log.warn("Client with {} was not found in the DB", dto.getClient().getId());
            throw new EntityNotFoundException("Aucun client avec l'ID " + dto.getClient().getId() + " n'a été trouvé dans la BDD", ErrorCode.CLIENT_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();

        if (dto.getLigneCommandeClients() != null) {
            dto.getLigneCommandeClients().forEach(ligCndClt -> {
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

        CommandeClient saveCmdClt = commandeClientRepository.save(CommandeCLientDto.toEntity(dto));

        if (dto.getLigneCommandeClients() != null) {
            dto.getLigneCommandeClients().forEach(ligCmdClt -> {
                LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligCmdClt);
                ligneCommandeClient.setCommandeclient(saveCmdClt);
                ligneCmdClientRepository.save(ligneCommandeClient);
            });
        }
        return CommandeCLientDto.fromEntity(saveCmdClt);
    }


    @Override
    public CommandeCLientDto findByIdCommandeClient(Integer id) {
        if(id == null){
            log.error("Commande client ID is NULL");
            return null;
        }
        return commandeClientRepository.findById(id).map(
                CommandeCLientDto::fromEntity
        ).orElseThrow(()-> new EntityNotFoundException("Aucune commande client n'a ete trouve avec l'id "+ id,ErrorCode.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public CommandeCLientDto findByCodeCommandeCLient(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("Commande client code is null");
            return null;
        }
        return commandeClientRepository.findCommandeClientByCode(code).map(
                CommandeCLientDto::fromEntity
        ).orElseThrow(()-> new EntityNotFoundException("Aucune commande client n'a ete trouve avec l ecode "+ code,ErrorCode.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public List<CommandeCLientDto> findAllCommandeCLient() {
        return commandeClientRepository.findAll().stream()
                .map(CommandeCLientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCommandeCLient(Integer id) {
     if(id == null){
         log.error("Commande client ID is null");
         return;
     }
     commandeClientRepository.deleteById(id);
    }
}
