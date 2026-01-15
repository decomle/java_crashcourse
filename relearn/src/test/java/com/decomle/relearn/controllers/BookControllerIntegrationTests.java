package com.decomle.relearn.controllers;

import com.decomle.relearn.TestDataUtil;
import com.decomle.relearn.domain.dto.BookDto;
import com.decomle.relearn.domain.entities.BookEntity;
import com.decomle.relearn.services.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class BookControllerIntegrationTests {
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private BookService bookService;

    @Autowired
    public BookControllerIntegrationTests(MockMvc mockMvc, BookService bookService) {
        this.mockMvc = mockMvc;
        this.objectMapper = new ObjectMapper();
        this.bookService = bookService;
    }

    @Test
    public void testIfBookCreatingSuccessfully() throws Exception {
        BookDto book = TestDataUtil.createTestBookDtoA(null);

        mockMvc.perform(MockMvcRequestBuilders.put("/books/" + book.getIsbn())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book))
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.isbn").value("978-1-2345-6789-0")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.title").value("The Shadow in the Attic")
        );
    }

    @Test
    public void testIfGetAllBooksSuccessfully() throws Exception {
        BookEntity book = TestDataUtil.createTestBookEntityA(null);
        this.bookService.save(book.getIsbn(), book);

        mockMvc.perform(MockMvcRequestBuilders.get("/books" )
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].isbn").value("978-1-2345-6789-0")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].title").value("The Shadow in the Attic")
        );
    }

    @Test
    public void testIfGetBookSuccessfully() throws Exception {
        BookEntity book = TestDataUtil.createTestBookEntityA(null);
        this.bookService.save(book.getIsbn(), book);

        mockMvc.perform(MockMvcRequestBuilders.get("/books/" + book.getIsbn() )
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isFound()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.isbn").value("978-1-2345-6789-0")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.title").value("The Shadow in the Attic")
        );
    }

    @Test
    public void testIfGetBookUnsuccessfully() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/books/aksdjalskjd" )
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isNotFound()
        );
    }

//    @Test
//    public void testIfFullUpdateBookSuccessfully() throws Exception {
//        BookEntity book = TestDataUtil.createTestBookEntityA(null);
//        this.bookService.save(book.getIsbn(), book);
//        book.setTitle("The Shadow in the Attic Update");
//
//        mockMvc.perform(MockMvcRequestBuilders.put("/books/" + book.getIsbn() )
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(this.objectMapper.writeValueAsString(book))
//        ).andExpect(
//                MockMvcResultMatchers.status().isOk()
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$.title").value("The Shadow in the Attic Update")
//        );
//    }
}
