package com.example.gestiondestock.services.impl;

import com.example.gestiondestock.dto.CategorieDto;
import com.example.gestiondestock.exception.EntityNotFoundException;
import com.example.gestiondestock.model.Categorie;
import com.example.gestiondestock.repository.CategorieRepository;
import com.example.gestiondestock.services.CategorieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CategorieServiceImpl implements CategorieService {
    private CategorieRepository categorieRepository;

    @Autowired
    public CategorieServiceImpl(CategorieRepository categorieRepository){
       this.categorieRepository = categorieRepository;
    }

    @Override
    public CategorieDto save(CategorieDto dto) {
        Categorie saveCategorie = categorieRepository.save(CategorieDto.toEntity(dto));
        return CategorieDto.fromEntity(saveCategorie);
    }

    @Override
    public CategorieDto findById(Integer id) {
        Optional<Categorie> categorie = categorieRepository.findById(id);
        return categorie.map(CategorieDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Categorie id not find"));
    }

    @Override
    public List<CategorieDto> findAll() {
        return categorieRepository
                .findAll()
                .stream().
                map(CategorieDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public CategorieDto findByCategorieCode(String codeCategorie) {
//        System.out.println("Recherche de la catégorie avec le code : " + codeCategorie); // console.log
//        Optional<Categorie> categorie = categorieRepository.findByCodeCategorie(codeCategorie);
//        return categorie.map(CategorieDto::fromEntity)
//                .orElseThrow(()-> new EntityNotFoundException("Categorie id not find"));
        String logMessage = "Recherche de la catégorie avec le code : " + codeCategorie;
        System.out.println(logMessage); // Affiche dans la console

        Optional<Categorie> categorie = categorieRepository.findByCodeCategorie(codeCategorie);
        CategorieDto categorieDto = categorie.map(CategorieDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Categorie id not find"));

        // Ajouter le message de log dans les en-têtes HTTP
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Log-Message", logMessage);

        return new ResponseEntity<>(categorieDto, headers, HttpStatus.OK).getBody();
    }

    @Override
    public void delete(Integer id) {
      if(id ==null){
          log.error("Id not null");
      }
      categorieRepository.deleteById(id);
    }
}
