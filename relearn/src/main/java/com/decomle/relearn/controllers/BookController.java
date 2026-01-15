package com.decomle.relearn.controllers;

import com.decomle.relearn.domain.dto.BookDto;
import com.decomle.relearn.domain.entities.AuthorEntity;
import com.decomle.relearn.domain.entities.BookEntity;
import com.decomle.relearn.mappers.Mapper;
import com.decomle.relearn.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class BookController {
    private final Mapper<BookEntity, BookDto> mapper;
    private final BookService bookService;

    public BookController(Mapper<BookEntity, BookDto> mapper, BookService bookService) {
        this.mapper = mapper;
        this.bookService = bookService;
    }

    @PutMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDto> createAndUpdateBook(@PathVariable String isbn, @RequestBody BookDto bookDto) {

        if(this.bookService.isExists(isbn)) {
            bookDto.setIsbn(isbn);

            BookEntity bookEntity = this.bookService.save(isbn, this.mapper.mapFrom(bookDto));
            return new ResponseEntity<>(this.mapper.mapTo(bookEntity), HttpStatus.OK);
        } else {
            BookEntity bookEntity = this.mapper.mapFrom(bookDto);
            BookEntity savedBook = this.bookService.save(isbn, bookEntity);
            return new ResponseEntity<>(this.mapper.mapTo(savedBook), HttpStatus.CREATED);
        }
    }

    @GetMapping(path = "/books")
    public List<BookDto> getAllBooks() {
        List<BookEntity> bookEntities = this.bookService.findAll();
        return bookEntities.stream().map(this.mapper::mapTo).collect(Collectors.toList());
    }

    @GetMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDto> getAllBook(@PathVariable String isbn) {
        Optional<BookEntity> bookEntity = this.bookService.findOne(isbn);
        return bookEntity
                .map(book -> new ResponseEntity<BookDto>(this.mapper.mapTo(book), HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
