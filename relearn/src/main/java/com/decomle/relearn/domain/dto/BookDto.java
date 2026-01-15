package com.decomle.relearn.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BookDto {
    private String isbn;
    private String title;
    private AuthorDto author;
}
