package com.decomle.relearn.services;

import com.decomle.relearn.domain.entities.UserEntity;

public interface UserService {
    UserEntity save(UserEntity user);

    String verify(UserEntity user);
}
