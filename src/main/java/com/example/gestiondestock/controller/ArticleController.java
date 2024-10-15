package com.example.gestiondestock.controller;

import com.example.gestiondestock.controller.api.ArticleApi;
import com.example.gestiondestock.dto.ArticleDto;
import com.example.gestiondestock.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ArticleController  implements ArticleApi {

    private ArticleService articleService;

    @Autowired
    public ArticleController(
    ArticleService articleService
    ){
     this.articleService = articleService;
    }
    @Override
    public ArticleDto save(ArticleDto dto) {
        return articleService.save(dto);
    }

    @Override
    public ArticleDto findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDto findByCode(String codeArticle) {
        return articleService.findByCode(codeArticle);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Integer id) {
        articleService.delete(id);
    }
}
