package com.example.gestiondestock.exception;

public enum ErrorCode {
    ARTICLE_NOT_FOUND(1000),
    ARTICLE_NOT_VALIO(1001),
    CATEGORY_NOT_FOUND(2000),
    // TODO complete the rest of the Error Codes
    CLIENT_NOT_FOUND(3000),
    COMMANDE_CLIENT_NOT_FOUND(4000),
    COMMANDE_CLIENT_NOT_VALID(4001),
    COMMANDE_FOURNISSEUR_NOT_VALID(5001),
    COMMANDE_FOURNISSEUR_NOT_FOUND(5000),
    ENTREPRISE_NOT_FOUND(6000),
    FOURNISSEUR_NOT_FOUND(7000),
    LIGNE_COMMANDE_CLIENT_NOT_FOUND(8000),
    LIGNE_COMMANDE_FOURNISSEUR_NOT_FOUND(9000),
    LIGNE_VENTE_NOT_FOUND(10000),
    MVT_STK_NOT_FOUND(11000),
    UTILISATEUR_NOT_FOUND(12000),
    VENTE_NOT_FOUND(13000),
    VENTE_NOT_VALID(13001)
    ;

    private int code;

    ErrorCode(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }
}
