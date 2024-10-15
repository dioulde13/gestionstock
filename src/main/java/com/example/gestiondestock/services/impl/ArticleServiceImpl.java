package com.example.gestiondestock.services.impl;

import com.example.gestiondestock.dto.ArticleDto;
import com.example.gestiondestock.exception.EntityNotFoundException;
import com.example.gestiondestock.exception.ErrorCode;
import com.example.gestiondestock.model.Article;
import com.example.gestiondestock.repository.ArticleRepository;
import com.example.gestiondestock.services.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository){
       this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        Article saveArticle = articleRepository.save(ArticleDto.toEntity(dto));
        return ArticleDto.fromEntity(saveArticle);
    }

    @Override
    public ArticleDto findById(Integer id) {
        Optional<Article> article = articleRepository.findById(id);
        return article.map(ArticleDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucun article avec cet ID n'est trouvé", ErrorCode.ARTICLE_NOT_FOUND));
    }

    @Override
    public ArticleDto findByCode(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle)) {
            log.error("Article code is null");
            return null;
        }

        Optional<Article> article = articleRepository.findArticleByCodeArticle(codeArticle);
        return article.map(ArticleDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucun article avec ce code n'est trouvé", ErrorCode.ARTICLE_NOT_FOUND));
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Article code is null");
            return;
        }
        articleRepository.deleteById(id);
    }
}
