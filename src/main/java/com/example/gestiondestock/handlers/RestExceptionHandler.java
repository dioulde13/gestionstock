package com.example.gestiondestock.handlers;

import com.example.gestiondestock.exception.EntityNotFoundException;
import com.example.gestiondestock.exception.InvalideEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
   @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(
     EntityNotFoundException exception, WebRequest WebRequest
    ){
     final HttpStatus notFound = HttpStatus.NOT_FOUND;
       // Création de l'instance d'ErrorDto
       ErrorDto errorDto = ErrorDto.builder()
               .code(exception.getErrorCode())
               .httpCode(notFound.value())
               .message(exception.getMessage())
               .build();
       // Retourne la réponse avec l'ErrorDto
       return new ResponseEntity<>(errorDto, notFound);
    }

    @ExceptionHandler(InvalideEntityException.class)
    public  ResponseEntity<ErrorDto> handleException(InvalideEntityException exception,WebRequest webRequest){
     final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ErrorDto errorDto = ErrorDto.builder()
                .code(exception.getErrorCode())
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();
        //Retourne la réponse avec l'ErrorDto
        return new ResponseEntity<>(errorDto, badRequest);
    }
}
