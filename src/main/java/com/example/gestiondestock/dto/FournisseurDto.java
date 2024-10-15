package com.example.gestiondestock.dto;

import com.example.gestiondestock.model.Fournisseur;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class FournisseurDto {

    private Integer id;
    private String nom;
    private String prenom;
    private AdresseDto adresse;
    private String photo;
    private String email;
    private String telephone;
    private List<CommandeFournisseurDto> commandefournisseur;

    // Méthode pour convertir un Fournisseur en FournisseurDto
    public static FournisseurDto fromEntity(Fournisseur fournisseur) {
        if (fournisseur == null) {
            return null;
        }
        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .adresse(AdresseDto.fromEntity(fournisseur.getAdresse()))  // Conversion de Adresse en AdresseDto
                .photo(fournisseur.getPhoto())
                .email(fournisseur.getEmail())
                .telephone(fournisseur.getTelephone())
                .build();
    }

    // Méthode pour convertir un FournisseurDto en Fournisseur
    public static Fournisseur toEntity(FournisseurDto fournisseurDto) {
        if (fournisseurDto == null) {
            return null;
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setNom(fournisseurDto.getNom());
        fournisseur.setPrenom(fournisseurDto.getPrenom());
        fournisseur.setAdresse(AdresseDto.toEntity(fournisseurDto.getAdresse()));  // Conversion de AdresseDto en Adresse
        fournisseur.setPhoto(fournisseurDto.getPhoto());
        fournisseur.setEmail(fournisseurDto.getEmail());
        fournisseur.setTelephone(fournisseurDto.getTelephone());
        return fournisseur;
    }
}
