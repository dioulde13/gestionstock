//package com.example.gestiondestock.config;
//
//import com.example.gestiondestock.model.Utilisateur;
//import com.example.gestiondestock.repository.UtilisateurRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//public class SecurityConfiguration {
//
//    @Autowired
//    private UtilisateurRepository utilisateurRepository;
//
//    @Bean
//    public static PasswordEncoder passwordEncoder(String passWord) {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return email -> {
//            // Récupération de l'utilisateur par email depuis la base de données
//            Utilisateur utilisateur = utilisateurRepository.findByEmail(email)
//                    .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé avec l'email : " + email));
//
//            // Conversion des informations de l'utilisateur en UserDetails pour Spring Security
//            return User.builder()
//                    .username(utilisateur.getEmail())
//                    .password(passwordEncoder(utilisateur.getPassWord()).toString()) // Assurez-vous que le mot de passe est encodé
//                    .roles() // Remplacez par la gestion des rôles de votre modèle Utilisateur
//                    .build();
//        };
//    }
//}
