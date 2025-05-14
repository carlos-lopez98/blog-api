package com.blogplatform.blogapi.service;

import com.blogplatform.blogapi.dto.AuthorDTO;
import com.blogplatform.blogapi.dto.PostDTO;
import com.blogplatform.blogapi.mapper.PostMapper;
import com.blogplatform.blogapi.model.Author;
import com.blogplatform.blogapi.model.Post;
import com.blogplatform.blogapi.repository.AuthorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Unit Tests for AuthorServiceImpl")
public class AuthorServiceImplTest {

    @Mock
    private AuthorRepository authorRepo;

    @InjectMocks
    private AuthorServiceImpl authorService;


    @Test
    @DisplayName("Test 1: Creating an Author")
    public void createAuthor() {
        AuthorDTO testAuthorDTO = new AuthorDTO(1L, "Hippo", "easy1123@gmail.com");
        Author testAuthor = new Author(1L, "Hippo", "easy1123@gmail.com");
        when(authorRepo.save(any(Author.class))).thenReturn(testAuthor);

        AuthorDTO returnedDTO = authorService.createAuthor(testAuthorDTO);
        assertEquals(returnedDTO.getEmail(), testAuthorDTO.getEmail());
        assertEquals(returnedDTO.getId(), testAuthorDTO.getId());
        assertEquals(returnedDTO.getName(), testAuthorDTO.getName());
    }


    @Test
    @DisplayName("Test 2: Retrieve all Authors")
    public void retrieveAuthors() {
        Author authorOne = new Author(1L, "Hippo", "easy1123@gmail.com");
        Author authorTwo = new Author(2L, "Elephant", "hard1123@gmail.com");

        List<Author> authors = List.of(authorOne, authorTwo);

        when(authorRepo.findAll()).thenReturn(authors);

        List<AuthorDTO> authorsDTOList = authorService.getAllAuthors();

        //Ensure return list is the same size of input
        assertEquals(authorsDTOList.size(), authors.size());

        for (int i = 0; i < authors.size(); i++) {
            assertEquals(authorsDTOList.get(i).getName(), authors.get(i).getName());
            assertEquals(authorsDTOList.get(i).getEmail(), authors.get(i).getEmail());
            assertEquals(authorsDTOList.get(i).getId(), authors.get(i).getId());
        }
    }

    @Test
    @DisplayName("Test 3: Retrieve author by Id")
    public void retrieveAuthorById() {
        Author authorOne = new Author(1L, "Hippo", "easy1123@gmail.com");
        when(authorRepo.findById(1L)).thenReturn(Optional.of(authorOne));

        assertNotNull(authorService.getAuthorById(1L));

        AuthorDTO result = authorService.getAuthorById(1L);

        assertAll("authorOne",
                () -> assertEquals(authorOne.getName(), result.getName()),
                () -> assertEquals(authorOne.getId(), result.getId()),
                () -> assertEquals(authorOne.getEmail(), result.getEmail())
        );
    }

    @Test
    @DisplayName("Test 4: Delete author by Id")
    public void deleteAuthorById() {
        Author testAuthor = new Author(1L, "Hippo", "easy1123@gmail.com");

        when(authorRepo.findById(1L)).thenReturn(Optional.of(testAuthor));

        authorService.deleteAuthor(1L);

        verify(authorRepo).deleteById(1L);
    }
}
