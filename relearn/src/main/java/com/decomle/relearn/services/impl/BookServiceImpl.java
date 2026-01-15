package com.decomle.relearn.services.impl;

import com.decomle.relearn.domain.entities.BookEntity;
import com.decomle.relearn.repositories.BookRepository;
import com.decomle.relearn.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity save(String isbn, BookEntity bookEntity) {
        bookEntity.setIsbn(isbn);
        return this.bookRepository.save(bookEntity);
    }

    @Override
    public List<BookEntity> findAll() {
        return StreamSupport.stream(
                this.bookRepository
                        .findAll()
                        .spliterator(),
                false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookEntity> findOne(String isbn) {
        return this.bookRepository.findById(isbn);
    }

    @Override
    public boolean isExists(String isbn) {
        return this.bookRepository.existsById(isbn);
    }
}
