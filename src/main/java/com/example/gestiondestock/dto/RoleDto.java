package com.example.gestiondestock.dto;

import com.example.gestiondestock.model.Role;
import com.example.gestiondestock.model.TypeRole;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoleDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String roleName;
    private Integer utilisateurId;
    private Integer idEntreprise;
    private UtilisateurDto utilisateur;

    // Méthode pour convertir un Role en RoleDto
    public static RoleDto fromEntity(Role role) {
        if (role == null) {
            return null;
        }
        return RoleDto.builder()
                .id(role.getId())
                .roleName(role.getRoleName() != null ? role.getRoleName().name() : null) // Conversion enum to String
                .utilisateurId(role.getUtilisateur() != null ? role.getUtilisateur().getId() : null) // Mapping de l'utilisateur ID
                .build();
    }

    // Méthode pour convertir un RoleDto en Role
    public static Role toEntity(RoleDto roleDto) {
        if (roleDto == null) {
            return null;
        }
        Role role = new Role();
        role.setId(roleDto.getId());
        role.setRoleName(TypeRole.valueOf(roleDto.getRoleName()));
        return role;
    }
}
