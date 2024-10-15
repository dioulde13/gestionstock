package com.example.gestiondestock.dto;

import com.example.gestiondestock.model.Entreprise;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class EntrepriseDto {

    private Integer id;
    private String nom;
    private AdresseDto adresse;
    private String prenom;
    private String photo;
    private String email;
    private String telephone;
    @JsonIgnore
    private List<UtilisateurDto> utilisateurList;

    // Méthode pour convertir un Entreprise en EntrepriseDto
    public static EntrepriseDto fromEntity(Entreprise entreprise) {
        if (entreprise == null) {
            return null;
        }
        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .adresse(AdresseDto.fromEntity(entreprise.getAdresse()))  // Conversion de Adresse en AdresseDto
                .prenom(entreprise.getPrenom())
                .photo(entreprise.getPhoto())
                .email(entreprise.getEmail())
                .telephone(entreprise.getTelephone())
                .build();
    }

    // Méthode pour convertir un EntrepriseDto en Entreprise
    public static Entreprise toEntity(EntrepriseDto entrepriseDto) {
        if (entrepriseDto == null) {
            return null;
        }
        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setAdresse(AdresseDto.toEntity(entrepriseDto.getAdresse()));  // Conversion de AdresseDto en Adresse
        entreprise.setPrenom(entrepriseDto.getPrenom());
        entreprise.setPhoto(entrepriseDto.getPhoto());
        entreprise.setEmail(entrepriseDto.getEmail());
        entreprise.setTelephone(entrepriseDto.getTelephone());// Conversion de la liste des utilisateurs
        return entreprise;
    }
}
