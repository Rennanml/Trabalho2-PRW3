package br.edu.ifsp.prw3.api_2025.service;
import br.edu.ifsp.prw3.api_2025.domain.Usuario;
import br.edu.ifsp.prw3.api_2025.persistence.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {
    private final UsuarioRepository repository;

    public AutenticacaoService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserDetails user = repository.findByLogin(username);
        System.out.println(user);
        return user;
    }
}