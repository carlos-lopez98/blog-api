package com.blogplatform.blogapi.mapper;

import com.blogplatform.blogapi.dto.PostDTO;
import com.blogplatform.blogapi.model.Author;
import com.blogplatform.blogapi.model.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.PostMapping;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

@DisplayName("Unit Tests for Post Mapper")

public class PostMapperTest {

    @Test
    @DisplayName("Test 1: Mapping from Post to PostDTO")
    public void testToDTO() {
        Author testAuthor = new Author(1L, "Hippo", "easy1123@gmail.com");
        Post testPost = new Post(2L, "Test Post", "This is a test post", LocalDateTime.now(), testAuthor);

        PostDTO testDTO = PostMapper.toDTO(testPost);

        assertEquals(testDTO.getAuthorId(), testPost.getAuthor().getId());
        assertEquals(testDTO.getContent(), testPost.getContent());
        assertEquals(testDTO.getTitle(), testPost.getTitle());
        assertEquals(testDTO.getCreatedAt(), testPost.getCreatedAt());
        assertEquals(testDTO.getId(), testPost.getId());

        System.out.println("Successful Test Run - Mapper is successfully mapping Post to Post DTO");
    }

    @Test
    @DisplayName("Test 2: Mapping from PostDTO to Post")
    public void testToPost(){
        PostDTO testDTO = new PostDTO(1L, "Test DTO", "This is a test DTO", LocalDateTime.now(), 1L);
        Post testPost = PostMapper.toPost(testDTO);

        assertEquals(testDTO.getId(), testPost.getId());
        assertEquals(testDTO.getAuthorId(), testPost.getAuthor().getId());
        assertEquals(testDTO.getContent(), testPost.getContent());
        assertEquals(testDTO.getTitle(), testPost.getTitle());
        assertEquals(testDTO.getCreatedAt(), testPost.getCreatedAt());
    }
}
