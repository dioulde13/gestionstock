//package com.example.gestiondestock.config;
//
//import com.example.gestiondestock.model.OurUser;
//import com.example.gestiondestock.repository.OurUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.Optional;
//
//public class OurUserInfoUserDetailService implements UserDetailsService {
//
//    @Autowired
//    private OurUserRepository ourUserRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<OurUser> user = ourUserRepository.findByEmail(username);
//        return user.map(OurUserInfoDetails::new).orElseThrow(()-> new UsernameNotFoundException("User not found"));
//    }
//}
