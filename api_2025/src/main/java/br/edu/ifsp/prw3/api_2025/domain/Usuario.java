package br.edu.ifsp.prw3.api_2025.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private String login;
    private String senha;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Return true to indicate the account is not expired
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Return true to indicate the account is not locked
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Return true to indicate the credentials are not expired
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Return true to indicate the user is enabled
        return true;
    }

}