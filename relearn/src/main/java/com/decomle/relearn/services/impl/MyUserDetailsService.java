package com.decomle.relearn.services.impl;

import com.decomle.relearn.domain.entities.UserEntity;
import com.decomle.relearn.repositories.UserRepository;
import lombok.extern.java.Log;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@Log
public class MyUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.userRepository.findByUsername(username);
        if(user==null) {
            log.info("User not found");
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrincipal(user);
    }

    private static class UserPrincipal implements UserDetails {
        private UserEntity user;

        public UserPrincipal(UserEntity user) {
            this.user = user;
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
            return UserDetails.super.isCredentialsNonExpired();
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return List.of(new SimpleGrantedAuthority("USER"));
        }

        @Override
        public String getPassword() {
            return this.user.getPassword();
        }

        @Override
        public String getUsername() {
            return this.user.getUsername();
        }
    }
}
