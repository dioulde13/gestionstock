package com.example.gestiondestock.exception;

import lombok.Getter;

import java.util.List;

public class InvalideEntityException extends RuntimeException{
    @Getter
    private  ErrorCode errorCode;
    @Getter
    private List<String> errors;

    public InvalideEntityException(String message){
        super(message);
    }
    public InvalideEntityException(String message, Throwable cause){
        super(message);
    }
    public InvalideEntityException(String message, Throwable cause, ErrorCode errorCode){
        super(message,cause);
        this.errorCode = errorCode;
    }
    public  InvalideEntityException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }
    public  InvalideEntityException(String message, ErrorCode errorCode, List<String> errors){
        super(message);
        this.errorCode = errorCode;
        this.errors = errors;
    }
}
