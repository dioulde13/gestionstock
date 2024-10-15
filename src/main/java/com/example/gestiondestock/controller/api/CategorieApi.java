package com.example.gestiondestock.controller.api;

import com.example.gestiondestock.dto.CategorieDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.example.gestiondestock.utils.Constants.APP_ROOT;
public interface CategorieApi {
    @PostMapping(value =APP_ROOT + "/categorie/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategorieDto saveCategorie(@RequestBody CategorieDto dto);

    @GetMapping(value = APP_ROOT + "/categorie/All", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategorieDto> findAll();


    @GetMapping(APP_ROOT + "/categorie/{idcategorie}")
    CategorieDto findCategorieId(@PathVariable Integer id);

    @GetMapping(APP_ROOT + "/categorie/code/{codeArticle}")
    CategorieDto findCategorieCode(@PathVariable String codeArticle);

    @DeleteMapping(value = APP_ROOT + "/categorie/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable Integer id);
}
