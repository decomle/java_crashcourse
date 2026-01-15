package com.decomle.relearn;

import com.decomle.relearn.domain.dto.AuthorDto;
import com.decomle.relearn.domain.dto.BookDto;
import com.decomle.relearn.domain.entities.AuthorEntity;
import com.decomle.relearn.domain.entities.BookEntity;

public class TestDataUtil {

    private TestDataUtil() {}

    public static AuthorDto createTestAuthorDtoA() {
        return AuthorDto.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }

    public static AuthorDto createTestAuthorDtoB() {
        return AuthorDto.builder()
                .id(2L)
                .name("Adam Parker")
                .age(36)
                .build();
    }

    public static AuthorDto createTestAuthorDtoC() {
        return AuthorDto.builder()
                .id(3L)
                .name("Adeline Rivers")
                .age(39)
                .build();
    }


    public static AuthorEntity createTestAuthorEntityA() {
        return AuthorEntity.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }

    public static AuthorEntity createTestAuthorEntityB() {
        return AuthorEntity.builder()
                .id(2L)
                .name("Adam Parker")
                .age(36)
                .build();
    }

    public static AuthorEntity createTestAuthorEntityC() {
        return AuthorEntity .builder()
                .id(3L)
                .name("Adeline Rivers")
                .age(39)
                .build();
    }

    public static BookDto createTestBookDtoA(final AuthorDto author) {
        return BookDto.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the Attic")
                .author(author)
                .build();
    }

    public static BookDto createTestBookDtoB(final AuthorDto author) {
        return BookDto.builder()
                .isbn("978-1-2345-6789-1")
                .title("Beyond the Horizon")
                .author(author)
                .build();
    }

    public static BookDto createTestBookDtoC(final AuthorDto author) {
        return BookDto.builder()
                .isbn("978-1-2345-6789-2")
                .title("The Last Ember")
                .author(author)
                .build();
    }


    public static BookEntity createTestBookEntityA(final AuthorEntity author) {
        return BookEntity.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the Attic")
                .author(author)
                .build();
    }

    public static BookEntity createTestBookEntityB(final AuthorEntity author) {
        return BookEntity.builder()
                .isbn("978-1-2345-6789-1")
                .title("Beyond the Horizon")
                .author(author)
                .build();
    }

    public static BookEntity createTestBookEntityC(final AuthorEntity author) {
        return BookEntity.builder()
                .isbn("978-1-2345-6789-2")
                .title("The Last Ember")
                .author(author)
                .build();
    }
}
