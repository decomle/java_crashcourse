package com.decomle.relearn.controllers;

import com.decomle.relearn.TestDataUtil;
import com.decomle.relearn.domain.dto.AuthorDto;
import com.decomle.relearn.domain.entities.AuthorEntity;
import com.decomle.relearn.services.AuthorService;
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
public class AuthorControllerIntegrationTests {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private AuthorService authorService;

    @Autowired
    public AuthorControllerIntegrationTests(MockMvc mockMvc, AuthorService authorService) throws Exception {
        this.mockMvc = mockMvc;
        this.objectMapper = new ObjectMapper();
        this.authorService = authorService;
    }

    @Test
    public void testCreateAuthorSuccessfully() throws Exception {
        AuthorDto author = TestDataUtil.createTestAuthorDtoA();
        author.setId(null);

        String authorJson = this.objectMapper.writeValueAsString(author);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/authors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(authorJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.name").value("Abigail Rose")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.age").value(80)
        );
    }

    @Test
    public void testIfGetAllAuthorsSuccessfully() throws Exception {
        AuthorEntity author = TestDataUtil.createTestAuthorEntityA();
        author.setId(null);
        this.authorService.save(author);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/authors")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].id").isNumber()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].name").value("Abigail Rose")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].age").value("80")
        );
    }

    @Test
    public void testIfGetAuthorSuccessfully() throws Exception {
        AuthorEntity author = TestDataUtil.createTestAuthorEntityA();
        author.setId(null);
        AuthorEntity savedAuthor = this.authorService.save(author);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/authors/" + savedAuthor.getId())
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isFound()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.name").value("Abigail Rose")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.age").value("80")
        );
    }

    @Test
    public void testIfGetAuthorUnSuccessfully() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/authors/9999")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isNotFound()
        );
    }

    @Test
    public void testIfFullUpdateAuthorSuccessfully() throws Exception {
        AuthorEntity author = TestDataUtil.createTestAuthorEntityA();
        author.setId(null);
        AuthorEntity savedAuthor = this.authorService.save(author);

        savedAuthor.setName("Abigail Rose Update");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/authors/" + savedAuthor.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(savedAuthor))
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.name").value("Abigail Rose Update")
        );
    }

    @Test
    public void testIfFullUpdateAuthorUnsuccessfully() throws Exception {
        AuthorEntity author = TestDataUtil.createTestAuthorEntityA();
        author.setName("Abigail Rose Update");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/authors/12312312")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(author))
        ).andExpect(
                MockMvcResultMatchers.status().isNotFound()
        );
    }
}
