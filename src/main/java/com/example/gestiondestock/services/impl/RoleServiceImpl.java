package com.example.gestiondestock.services.impl;

import com.example.gestiondestock.dto.RoleDto;
import com.example.gestiondestock.exception.EntityNotFoundException;
import com.example.gestiondestock.model.Role;
import com.example.gestiondestock.model.Utilisateur;
import com.example.gestiondestock.repository.RoleRepository;
import com.example.gestiondestock.repository.UtilisateurRepository;
import com.example.gestiondestock.services.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, UtilisateurRepository utilisateurRepository){
        this.roleRepository = roleRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public RoleDto createRole(RoleDto dto) {
        System.out.println("fjjfjfjf");
        if (dto.getUtilisateurId() == null) {
            throw new IllegalArgumentException("L'ID utilisateur est requis");
        }
        // Récupération de l'utilisateur à partir de l'ID
        Utilisateur utilisateur = utilisateurRepository.findById(dto.getUtilisateurId())
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé avec l'ID " + dto.getUtilisateurId()));
        // Convertir le DTO en entité Role
        Role role = RoleDto.toEntity(dto);
        role.setUtilisateur(utilisateur); // Associer l'utilisateur au rôle

        // Sauvegarder le rôle
        Role createRole = roleRepository.save(role);

        return RoleDto.fromEntity(createRole);
    }

    @Override
    public List<Role> listAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public RoleDto findByIdRole(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("L'id ne doit pas être null");
        }
        Optional<Role> findByIdRole = roleRepository.findById(id);
        return findByIdRole.map(RoleDto::fromEntity).orElseThrow(
                () -> new EntityNotFoundException("L'id role n'a pas été trouvé")
        );
    }

//    @Override
//    public Optional<RoleDto> updateRole(RoleDto dto, Integer id) {
//        return roleRepository.findById(id).map(
//                role -> {
//                    role.setId(dto.getId());
//                    role.setRoleName(dto.getRoleName());
//                    if (dto.getUtilisateurId() != null) {
//                        Utilisateur utilisateur = utilisateurRepository.findById(dto.getUtilisateurId())
//                                .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé avec l'ID " + dto.getUtilisateurId()));
//                        role.setUtilisateur(utilisateur);
//                    }
//                    Role updateRole = roleRepository.save(role);
//                    return RoleDto.fromEntity(updateRole);
//                }
//        );
//    }

    @Override
    public void deleteRole(Integer id) {
        if (id == null) {
            log.error("l'id role n'existe pas");
            return;
        }
        roleRepository.deleteById(id);
    }
}
