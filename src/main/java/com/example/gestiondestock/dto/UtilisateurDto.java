package com.example.gestiondestock.dto;

import com.example.gestiondestock.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class UtilisateurDto {

    private Integer id;
    private String nom;
    private String prenom;
    private AdresseDto adresse;
    private String photo;
    private String email;
    private String password;
    private String telephone;
    private EntrepriseDto entreprise;
    private Integer idEntreprise;
    private List<RoleDto> rolelist;

    // Méthode pour convertir un Utilisateur en UtilisateurDto
    public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return null;
        }
        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))  // Conversion de Adresse en AdresseDto
                .photo(utilisateur.getPhoto())
                .email(utilisateur.getEmail())
                .password(utilisateur.getPassword())
                .telephone(utilisateur.getTelephone())
                .entreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))  // Conversion de Entreprise en EntrepriseDto
                // Conversion de la liste de roles
                .rolelist(utilisateur.getRolelist() != null ?
                        utilisateur.getRolelist().stream()
                                .map(RoleDto::fromEntity)
                                .collect(Collectors.toList()) : null)
                .build();
    }

    // Méthode pour convertir un UtilisateurDto en Utilisateur
    public static Utilisateur toEntity(UtilisateurDto utilisateurDto) {
        if (utilisateurDto == null) {
            return null;
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setAdresse(AdresseDto.toEntity(utilisateurDto.getAdresse()));  // Conversion de AdresseDto en Adresse
        utilisateur.setPhoto(utilisateurDto.getPhoto());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setPassword(utilisateurDto.getPassword());
        utilisateur.setTelephone(utilisateurDto.getTelephone());
        utilisateur.setEntreprise(EntrepriseDto.toEntity(utilisateurDto.getEntreprise()));  // Conversion de EntrepriseDto en Entreprise
        // Conversion de la liste de roles
        utilisateur.setRolelist(utilisateurDto.getRolelist() != null ?
                utilisateurDto.getRolelist().stream()
                        .map(RoleDto::toEntity)
                        .collect(Collectors.toList()) : null);
        return utilisateur;
    }
}
