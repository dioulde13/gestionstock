package com.example.gestiondestock.controller;

import com.example.gestiondestock.controller.api.UtilisateurApi;
import com.example.gestiondestock.dto.AuthentificationDTO;
import com.example.gestiondestock.dto.UtilisateurDto;
import com.example.gestiondestock.model.OurUser;
import com.example.gestiondestock.model.Utilisateur;
import com.example.gestiondestock.services.UtilisateurService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@RestController
public class UtilisateurController implements UtilisateurApi {
    private UtilisateurService utilisateurService;
    private AuthenticationManager authenticationManager;

//    @Autowired
//    private OurUserRepository ourUserRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//
//    @PostMapping("/user/save")
//    public ResponseEntity<Object> saveUser(@RequestBody OurUser ourUser){
//        ourUser.setPassword(passwordEncoder.encode(ourUser.getPassword()));
//        OurUser result = ourUserRepository.save(ourUser);
//        if(result.getId() > 0){
//            return ResponseEntity.ok("User was save");
//        }
//        return ResponseEntity.status(404).body("Error, User not saved");
//    }
//
//    @GetMapping("/users/all")
//    @PreAuthorize("hasAuthority('ADMIN')")
//    public ResponseEntity<Object> getAllUsers(){
//        return ResponseEntity.ok(ourUserRepository.findAll());
//    }
//
//    @GetMapping("/users/single")
//    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
//    public ResponseEntity<Object> getMyDeatails(){
//        return ResponseEntity.ok(ourUserRepository.findByEmail(getLoggedUserDetails().getUsername()));
//    }
//
//    public UserDetails getLoggedUserDetails(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if(authentication != null && authentication.getPrincipal() instanceof UserDetails){
//           return  (UserDetails) authentication.getPrincipal();
//        }
//        return null;
//    }

    @Override
    public UtilisateurDto saveUtilisateur(UtilisateurDto dto) {
        return utilisateurService.saveUtilisateur(dto);
    }

    @Override
    public Map<String, String> connexion(AuthentificationDTO authentificationDTO) {
       final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authentificationDTO.usename(), authentificationDTO.password())
        );
       log.info("resultat", authentication.isAuthenticated());
        return Map.of();
    }

    @Override
    public Optional<UtilisateurDto> updateUtilisateur(UtilisateurDto dto, Integer id) {
        return utilisateurService.updateUtilisateur(dto,id);
    }

    @Override
    public List<Utilisateur> listUtilisateur() {
        return utilisateurService.getAllUtilisateur();
    }

    @Override
    public UtilisateurDto findByIdUtilisateur(Integer id) {
        return utilisateurService.findByIdUtilisateur(id);
    }

    @Override
    public UtilisateurDto findByTelephone(String telephone) {
        return utilisateurService.findByTelephone(telephone);
    }
}
