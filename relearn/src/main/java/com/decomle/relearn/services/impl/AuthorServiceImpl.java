package com.decomle.relearn.services.impl;

import com.decomle.relearn.domain.entities.AuthorEntity;
import com.decomle.relearn.repositories.AuthorRepository;
import com.decomle.relearn.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity save(AuthorEntity authorEntity) {
        return this.authorRepository.save(authorEntity);
    }

    @Override
    public List<AuthorEntity> findAll() {
        return StreamSupport.stream(this.authorRepository
                .findAll()
                .spliterator(), false)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<AuthorEntity> findOne(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Boolean isExists(Long id) {
        return this.authorRepository.existsById(id);
    }

    @Override
    public AuthorEntity partialUpdate(Long id, AuthorEntity authorEntity) {
        authorEntity.setId(id);
        return this.authorRepository.findById(id).map(existingAuthor -> {
            Optional.ofNullable(authorEntity.getAge()).ifPresent(existingAuthor::setAge);
            Optional.ofNullable(authorEntity.getName()).ifPresent(existingAuthor::setName);

            return this.authorRepository.save(existingAuthor);
        }).orElseThrow(()-> new RuntimeException("Author does not existed"));
    }
}
