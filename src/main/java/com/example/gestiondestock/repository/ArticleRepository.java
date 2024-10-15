package com.example.gestiondestock.repository;

import com.example.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository <Article, Integer>{
//@Query("select a from article where codearticle = :code")
//List<Article> findByCustomQuery(@Param("code") String c);
//
//@Query(value = "select * article where code = :code", nativeQuery = true)
//List<Article> findByCustomNative(@Param("code") String c);
//
//List<Article> findByCodeArticleIgnoreCaseAndDesignationIgnoreCase(String codeArticle, String designation);
Optional<Article> findArticleByCodeArticle(String codeArticle);
}
