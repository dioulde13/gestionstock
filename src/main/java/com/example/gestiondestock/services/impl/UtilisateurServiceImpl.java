package com.example.gestiondestock.services.impl;

import com.example.gestiondestock.dto.RoleDto;
import com.example.gestiondestock.dto.UtilisateurDto;
import com.example.gestiondestock.exception.EntityNotFoundException;
import com.example.gestiondestock.model.Role;
import com.example.gestiondestock.model.TypeRole;
import com.example.gestiondestock.model.Utilisateur;
import com.example.gestiondestock.repository.UtilisateurRepository;
import com.example.gestiondestock.services.UtilisateurService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public UtilisateurDto saveUtilisateur(UtilisateurDto dto) {
        // Vérification de la validité de l'email
        if(!dto.getEmail().contains("@") || !dto.getEmail().contains(".")) {
            throw new RuntimeException("Votre mail est invalide");
        }

        // Vérification si l'email existe déjà dans la base de données
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findByEmail(dto.getEmail());
        if(utilisateurOptional.isPresent()) {
            throw new RuntimeException("Cet email est déjà utilisé");
        }

        // Cryptage du mot de passe
        String motPasseCrypter = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(motPasseCrypter);

//        // Création d'un nouveau rôle utilisateur
//        Role roleUtilisateur = new Role();
//        roleUtilisateur.setRoleName(TypeRole.UTILISATEUR);  // Assigner le rôle UTILISATEUR
//
//        // Ajout du rôle à la liste des rôles de l'utilisateur
//        dto.getRolelist().add(RoleDto.fromEntity(roleUtilisateur));  // Assurez-vous que la liste des rôles n'est pas null

        // Enregistrement de l'utilisateur
        Utilisateur saveUtilisateur = utilisateurRepository.save(UtilisateurDto.toEntity(dto));

        return UtilisateurDto.fromEntity(saveUtilisateur);
    }

    @Override
    public Optional<UtilisateurDto> updateUtilisateur(UtilisateurDto dto, Integer id) {
        return utilisateurRepository.findById(id).map(
                utilisateur -> {
                    utilisateur.setNom(dto.getNom());
                    utilisateur.setPrenom(dto.getPrenom());
                    utilisateur.setEmail(dto.getEmail());
                    utilisateur.setTelephone(dto.getTelephone());
                    Utilisateur updateUtilisateur = utilisateurRepository.save(utilisateur);
                    return UtilisateurDto.fromEntity(updateUtilisateur);
                }
        );
    }

    @Override
    public List<Utilisateur> getAllUtilisateur() {
        return utilisateurRepository.findAll();
    }

    @Override
    public UtilisateurDto findByIdUtilisateur(Integer id) {
        Optional<Utilisateur> findById = utilisateurRepository.findById(id);
        return findById.map(UtilisateurDto::fromEntity).orElseThrow(
                ()->new EntityNotFoundException("L'id n'a pas ete trouver")
        );
    }

    @Override
    public UtilisateurDto findByTelephone(String telephone) {
        Optional<Utilisateur> findByTelephone = utilisateurRepository.findByTelephone(telephone);
        return findByTelephone.map(UtilisateurDto::fromEntity).orElseThrow(
                ()->new EntityNotFoundException("Le telephone n'a pas ete trouver")
        );
    }

    @Override
    public void deleteUtilisateur(Integer id) {
      if(id == null){
          log.error("l'id n'a pas ete trouver");
          return;
      }
      utilisateurRepository.deleteById(id);
    }
}
