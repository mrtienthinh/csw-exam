package com.mrtienthinh.exam.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;

    public CustomUserDetails() {
        super();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        List<SimpleGrantedAuthority> authories = new ArrayList<>();
        authories.add(new SimpleGrantedAuthority("admin"));
        return authories;
    }

    @Override
    public String getPassword() {
        return "$2a$12$zbj0PQ7HCXHkmSmzTZmmVu3eYj84nEAjOqXVgDDy9FwtQr9rR9x5i";
    }


    @Override
    public String getUsername() {
        return "admin";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean hasRole(String roleName) {
        return true;
    }

    @Override
    public String toString() {
        return "CustomUserDetails [user=admin]";
    }

}
