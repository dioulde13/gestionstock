package com.example.gestiondestock.validator;

import com.example.gestiondestock.dto.CommandeCLientDto;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CommandeCLientValidator {
    public static List<String> validate(CommandeCLientDto commandeCLientDto){
        List<String> errors =new ArrayList<>();
        return errors;
    }
}
