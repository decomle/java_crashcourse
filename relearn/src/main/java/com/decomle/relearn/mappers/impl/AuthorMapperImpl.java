package com.decomle.relearn.mappers.impl;

import com.decomle.relearn.domain.dto.AuthorDto;
import com.decomle.relearn.domain.entities.AuthorEntity;
import com.decomle.relearn.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImpl implements Mapper<AuthorEntity, AuthorDto> {

    private final ModelMapper modelMapper;

    public AuthorMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorDto mapTo(AuthorEntity authorEntity) {
        return this.modelMapper.map(authorEntity, AuthorDto.class);
    }

    @Override
    public AuthorEntity mapFrom(AuthorDto authorDto) {
        return this.modelMapper.map(authorDto, AuthorEntity.class);
    }
}
