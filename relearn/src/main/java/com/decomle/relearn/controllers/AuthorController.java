package com.decomle.relearn.controllers;

import com.decomle.relearn.domain.entities.AuthorEntity;
import com.decomle.relearn.domain.dto.AuthorDto;
import com.decomle.relearn.mappers.Mapper;
import com.decomle.relearn.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AuthorController {

    private final AuthorService authorService;
    private final Mapper<AuthorEntity, AuthorDto> authorMapper;

    public AuthorController(AuthorService authorService, Mapper<AuthorEntity, AuthorDto> authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping(path = "/authors")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto author) {
        AuthorEntity authorEntity = this.authorMapper.mapFrom(author);
        AuthorEntity savedAuthorEntity = this.authorService.save(authorEntity);
        return new ResponseEntity<>(this.authorMapper.mapTo(savedAuthorEntity), HttpStatus.CREATED);
    }

    @GetMapping(path = "/authors")
    public List<AuthorDto> getAuthors() {
        List<AuthorEntity> authorEntities = this.authorService.findAll();
        return authorEntities.stream().map(this.authorMapper::mapTo).collect(Collectors.toList());
    }

    @GetMapping(path = "/authors/{id}")
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable Long id) {
        Optional<AuthorEntity> authorEntity = this.authorService.findOne(id);
        return authorEntity
                .map(author -> new ResponseEntity<>(this.authorMapper.mapTo(author), HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(path = "/authors/{id}")
    public ResponseEntity<AuthorDto> fullUpdateAuthor(@PathVariable Long id, @RequestBody AuthorDto authorDto) {
        if(!this.authorService.isExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        authorDto.setId(id);

        AuthorEntity authorEntity = this.authorService.save(this.authorMapper.mapFrom(authorDto));
        return new ResponseEntity<>(this.authorMapper.mapTo(authorEntity), HttpStatus.OK);
    }
}
