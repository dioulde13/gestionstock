package com.example.gestiondestock.controller.api;

import com.example.gestiondestock.dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import  static com.example.gestiondestock.utils.Constants.APP_ROOT;

public interface ArticleApi {
    @PostMapping(value = APP_ROOT + "/article/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save(@RequestBody ArticleDto dto);

    @GetMapping(value = APP_ROOT + "/article/{idartcile}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable("idartcile") Integer id);

    @GetMapping(value = APP_ROOT + "/articles/{codeartcile}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCode(@PathVariable("codeartcile") String codeArticle);

    @GetMapping(value = APP_ROOT + "/article/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/article/delete/{id}")
    void delete(@PathVariable Integer id);
}
