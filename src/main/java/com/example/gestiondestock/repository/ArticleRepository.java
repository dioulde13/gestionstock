package com.example.gestiondestock.repository;

import com.example.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
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
