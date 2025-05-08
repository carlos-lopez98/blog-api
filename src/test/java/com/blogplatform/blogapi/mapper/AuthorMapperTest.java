package com.blogplatform.blogapi.mapper;
import static org.junit.jupiter.api.Assertions.*;

import com.blogplatform.blogapi.dto.AuthorDTO;
import com.blogplatform.blogapi.model.Author;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Unit Tests for Author Mapper")
public class AuthorMapperTest {

    @Test
    @DisplayName("Testing Mapping from Author to DTO")
    void testToDTO() {
        Author author = new Author(1L, "Hippo", "easyemail123@gmail.com");
        AuthorDTO dto = AuthorMapper.toDTO(author);


        assertEquals(author.getId(), dto.getId());
        assertEquals(author.getName(), dto.getName());
        assertEquals(author.getEmail(), dto.getEmail());

        System.out.println("Successful Test Run");
    }
}
