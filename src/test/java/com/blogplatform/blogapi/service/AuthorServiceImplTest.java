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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
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
}
