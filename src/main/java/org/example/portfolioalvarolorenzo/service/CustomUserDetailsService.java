package org.example.portfolioalvarolorenzo.service;

import org.example.portfolioalvarolorenzo.model.Usuario;
import org.example.portfolioalvarolorenzo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import
        org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;
/*
Spring Security llama a loadUserByUsername() cuando alguien intenta hacer
login
Busca el usuario en la base de datos
Devuelve un objeto UserDetails con las credenciales y roles
Si no existe, lanza UsernameNotFoundException
*/
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {
        // Buscar el usuario en la base de datos
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
        // Convertir a UserDetails de Spring Security
        return new User(
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getEnabled(),
                true, // accountNonExpired
                true, // credentialsNonExpired
                true, // accountNonLocked
                Collections.singletonList(new
                        SimpleGrantedAuthority(usuario.getRole()))
        );
    }
}