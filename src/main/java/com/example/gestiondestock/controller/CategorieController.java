package com.example.gestiondestock.controller;

import com.example.gestiondestock.controller.api.CategorieApi;
import com.example.gestiondestock.dto.CategorieDto;
import com.example.gestiondestock.services.CategorieService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategorieController implements CategorieApi {
    private CategorieService categorieService;

    public CategorieController(CategorieService categorieService){
        this.categorieService = categorieService;
    }

    @Override
    public CategorieDto saveCategorie(CategorieDto dto) {
        return categorieService.save(dto);
    }

    @Override
    public List<CategorieDto> findAll() {
        return categorieService.findAll();
    }

    @Override
    public CategorieDto findCategorieId(Integer id) {
        return categorieService.findById(id);
    }

    @Override
    public CategorieDto findCategorieCode(String codeArticle) {
        return categorieService.findByCategorieCode(codeArticle);
    }

    @Override
    public void delete(Integer id) {
        categorieService.delete(id);
    }
}
