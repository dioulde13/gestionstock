package com.example.gestiondestock.services;

import com.example.gestiondestock.dto.ArticleDto;

import java.util.List;

public interface ArticleService {
    ArticleDto save(ArticleDto dto);
    ArticleDto findById(Integer id);
    ArticleDto findByCode(String codeArticle);
    List<ArticleDto> findAll();
    void delete(Integer id);
}
