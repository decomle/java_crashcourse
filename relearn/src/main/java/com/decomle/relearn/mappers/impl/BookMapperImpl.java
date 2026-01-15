package com.decomle.relearn.mappers.impl;

import com.decomle.relearn.domain.dto.BookDto;
import com.decomle.relearn.domain.entities.BookEntity;
import com.decomle.relearn.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements Mapper<BookEntity, BookDto> {

    private final ModelMapper modelMapper;

    public BookMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDto mapTo(BookEntity bookEntity) {
        return this.modelMapper.map(bookEntity, BookDto.class);
    }

    @Override
    public BookEntity mapFrom(BookDto bookDto) {
        return this.modelMapper.map(bookDto, BookEntity.class);
    }
}
