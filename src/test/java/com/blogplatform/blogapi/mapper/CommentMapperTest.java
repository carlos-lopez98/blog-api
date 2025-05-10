package com.blogplatform.blogapi.mapper;


import com.blogplatform.blogapi.dto.CommentDTO;
import com.blogplatform.blogapi.model.Author;
import com.blogplatform.blogapi.model.Comment;
import com.blogplatform.blogapi.model.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Unit Tests for Comment Mapper")
public class CommentMapperTest {

    @Test
    @DisplayName("Test 1: Mapping from Comment to CommentDTO")
    void testToDTO(){

        Author testAuthor = new Author(1L, "Hippo", "easy1123@gmail.com");
        Post testPost = new Post(1L, "Test Post", "This is a test post", LocalDateTime.now(), testAuthor);
        Comment testComment = new Comment(1L, "This is a test post", "Hippo", testPost, LocalDateTime.now());

        CommentDTO dto = CommentMapper.toDTO(testComment);

        assertEquals(dto.getContent(), testComment.getContent());
        assertEquals(dto.getId(), testComment.getId());
        assertEquals(dto.getCreatedAt(), testComment.getCreatedAt());
        assertEquals(dto.getPosterName(), testComment.getPosterName());

        System.out.println("Successful Test Run - Mapper is successfully mapping Comment to Comment DTO");

    }

    @Test
    @DisplayName("Test 2: Mapping from CommentDTO to Comment")
    void testToComment(){
        CommentDTO testDTO = new CommentDTO(1L, "This is a test dto", "Hippo", 2L, LocalDateTime.now());
        Comment testComment = CommentMapper.toComment(testDTO);

        assertEquals(testDTO.getPosterName(), testComment.getPosterName());
        assertEquals(testDTO.getPostId(), testComment.getPost().getId());
        assertEquals(testDTO.getContent(), testComment.getContent());
        assertEquals(testDTO.getCreatedAt(), testComment.getCreatedAt());

        System.out.println("Successful Test Run - Mapper is successfully mapping CommentDTO to Comment");

    }
}
