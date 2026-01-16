package com.decomle.relearn.controllers;

import com.decomle.relearn.domain.dto.UserDto;
import com.decomle.relearn.domain.entities.UserEntity;
import com.decomle.relearn.mappers.Mapper;
import com.decomle.relearn.mappers.impl.UserMapperImpl;
import com.decomle.relearn.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;
    private Mapper<UserEntity, UserDto> mapper;

    public UserController(UserService userService, Mapper<UserEntity, UserDto> mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @PostMapping(path = "/users")
    public UserDto createUser(@RequestBody UserDto userDto) {
        UserEntity user = this.userService.save(this.mapper.mapFrom(userDto));
        return this.mapper.mapTo(user);
    }
}
