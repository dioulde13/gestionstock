//package com.example.gestiondestock.config;
//
//import com.example.gestiondestock.model.OurUser;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//// Cette classe implémente l'interface UserDetails de Spring Security
//// Elle permet de définir la manière dont les détails de l'utilisateur (comme email, mot de passe et rôles) seront récupérés.
//public class OurUserInfoDetails implements UserDetails {
//
//    // Attributs privés pour stocker l'email, le mot de passe et les rôles de l'utilisateur
//    private String email;
//    private String password;
//    private List<GrantedAuthority> roles;
//
//    // Constructeur qui prend un objet OurUser et initialise les attributs
//    public OurUserInfoDetails(OurUser ourUser) {
//        // Initialisation de l'email et du mot de passe à partir de l'objet OurUser
//        this.email = ourUser.getEmail();
//        this.password = ourUser.getPassword();
//
//        // Conversion des rôles (séparés par des virgules) en une liste d'autorités Spring Security (GrantedAuthority)
//        this.roles = Arrays.stream(ourUser.getRoles().split(","))
//                .map(SimpleGrantedAuthority::new)  // Pour chaque rôle, créer une SimpleGrantedAuthority
//                .collect(Collectors.toList());     // Collecter les résultats dans une liste
//    }
//
//    // Méthode qui retourne la collection d'autorités (rôles) de l'utilisateur
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.roles;  // Retourne la liste des rôles de l'utilisateur
//    }
//
//    // Retourne le mot de passe de l'utilisateur
//    @Override
//    public String getPassword() {
//        return this.password;
//    }
//
//    // Retourne le nom d'utilisateur, ici c'est l'email
//    @Override
//    public String getUsername() {
//        return this.email;
//    }
//
//    // Méthode pour indiquer si le compte de l'utilisateur est expiré (ici, toujours non expiré)
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;  // Toujours retourner true pour indiquer que le compte n'est pas expiré
//    }
//
//    // Méthode pour indiquer si le compte de l'utilisateur est verrouillé (ici, toujours non verrouillé)
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;  // Toujours retourner true pour indiquer que le compte n'est pas verrouillé
//    }
//
//    // Méthode pour indiquer si les informations d'identification (mot de passe) de l'utilisateur sont expirées
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;  // Toujours retourner true pour indiquer que les informations d'identification ne sont pas expirées
//    }
//
//    // Méthode pour indiquer si le compte est activé (ici, toujours activé)
//    @Override
//    public boolean isEnabled() {
//        return true;  // Toujours retourner true pour indiquer que le compte est activé
//    }
//}
