package com.example.gestiondestock.dto;

import com.example.gestiondestock.model.Role;
import com.example.gestiondestock.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoleDto {

    private Integer id;
    private String roleName;
    private UtilisateurDto utilisateur;

    // Méthode pour convertir un Role en RoleDto
    public static RoleDto fromEntity(Role role) {
        if (role == null) {
            return null;
        }
        return RoleDto.builder()
                .id(role.getId())
                .roleName(role.getRoleName())
                .build();
    }

    // Méthode pour convertir un RoleDto en Role
    public static Role toEntity(RoleDto roleDto) {
        if (roleDto == null) {
            return null;
        }
        Role role = new Role();
        role.setId(roleDto.getId());
        role.setRoleName(roleDto.getRoleName());
        return role;
    }
}
