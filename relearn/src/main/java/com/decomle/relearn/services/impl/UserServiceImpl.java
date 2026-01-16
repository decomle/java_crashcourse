package com.decomle.relearn.services.impl;

import com.decomle.relearn.domain.entities.UserEntity;
import com.decomle.relearn.repositories.UserRepository;
import com.decomle.relearn.services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder;
    private AuthenticationManager authenticationManager;
    private JWTService jwtService;

    public UserServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager, JWTService jwtService) {
        this.encoder = new BCryptPasswordEncoder(10);
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public UserEntity save(UserEntity user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    @Override
    public String verify(UserEntity user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        return authentication.isAuthenticated() ? this.jwtService.generateToken(user.getUsername()) : "fail";
    }
}
