package com.decomle.relearn.mappers.impl;

import com.decomle.relearn.domain.dto.UserDto;
import com.decomle.relearn.domain.entities.UserEntity;
import com.decomle.relearn.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements Mapper<UserEntity, UserDto> {

    private final ModelMapper modelMapper;

    public UserMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto mapTo(UserEntity user) {
        return this.modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserEntity mapFrom(UserDto userDto) {
        return this.modelMapper.map(userDto, UserEntity.class);
    }
}
