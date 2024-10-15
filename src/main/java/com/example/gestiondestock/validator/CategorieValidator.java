package com.example.gestiondestock.validator;


import com.example.gestiondestock.dto.CategorieDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
public class CategorieValidator {
    public static List<String> validate(CategorieDto categorieDto){
        List<String> errors =new ArrayList<>();

        if(categorieDto == null || !StringUtils.hasLength(categorieDto.getCodeCategorie())){
            errors.add("Veuillez renseigner le code de le categorie");
        }
        return errors;
    }

}
