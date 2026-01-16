package com.decomle.relearn.services.impl;

import com.decomle.relearn.domain.entities.UserEntity;
import com.decomle.relearn.repositories.UserRepository;
import com.decomle.relearn.services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.encoder = new BCryptPasswordEncoder(10);
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity save(UserEntity user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }
}
