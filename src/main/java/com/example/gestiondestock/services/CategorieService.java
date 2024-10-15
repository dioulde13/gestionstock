package com.example.gestiondestock.services;


import com.example.gestiondestock.dto.CategorieDto;

import java.util.List;

public interface CategorieService {
    CategorieDto save(CategorieDto dto);
    CategorieDto findById(Integer id);
    List<CategorieDto> findAll();
    CategorieDto findByCategorieCode(String codeCategorie);
    void delete(Integer id);
}
