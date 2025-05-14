package com.blogplatform.blogapi.service;

import com.blogplatform.blogapi.dto.PostDTO;
import com.blogplatform.blogapi.model.Author;
import com.blogplatform.blogapi.model.Post;
import com.blogplatform.blogapi.repository.AuthorRepository;
import com.blogplatform.blogapi.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//TODO Need to add negative test cases
@ExtendWith(MockitoExtension.class)
@DisplayName("Unit Tests for PostServiceImpl")
public class PostServiceImplTest {

    @Mock
    private AuthorRepository authorRepo;

    @Mock
    private PostRepository postRepo;

    @InjectMocks
    private PostServiceImpl postService;


    @Test
    @DisplayName("Test 1: Creating an Post")
    public void createPost() {
        Author testAuthor = new Author(1L, "Hippo", "easy1123@gmail.com");

        when(authorRepo.findById(1L)).thenReturn(Optional.of(testAuthor));

        //Create Test PostDTO
        PostDTO testPostDTO = new PostDTO();
        testPostDTO.setAuthorId(1L);
        testPostDTO.setCreatedAt(LocalDateTime.now());
        testPostDTO.setId(1L);
        testPostDTO.setContent("Test Content");
        testPostDTO.setTitle("Test Post");

        //Create Test Post
        Post testPost = new Post();
        testPost.setAuthor(testAuthor);
        testPost.setCreatedAt(LocalDateTime.now());
        testPost.setId(1L);
        testPost.setContent("Test Content");
        testPost.setTitle("Test Post");

        when(postRepo.save(any(Post.class))).thenReturn(testPost);

        PostDTO result = postService.createPost(testPostDTO);

        assertAll("testPost",
                () -> assertEquals(testPost.getCreatedAt(), result.getCreatedAt()),
                () -> assertEquals(testPost.getAuthor().getId(), result.getAuthorId()),
                () -> assertEquals(testPost.getContent(), result.getContent()),
                () -> assertEquals(testPost.getId(), result.getId()),
                () -> assertEquals(testPost.getTitle(), result.getTitle())
        );
    }

    @Test
    @DisplayName("Test 2: Retrieve all Posts")
    public void retrieveAuthors() {
        Author testAuthor = new Author(1L, "Hippo", "easy1123@gmail.com");

        //Post One
        Post testPostOne = new Post();
        testPostOne.setAuthor(testAuthor);
        testPostOne.setCreatedAt(LocalDateTime.now());
        testPostOne.setId(1L);
        testPostOne.setContent("Test Content");
        testPostOne.setTitle("Test Post");

        Post testPostTwo = new Post();
        testPostTwo.setAuthor(testAuthor);
        testPostTwo.setCreatedAt(LocalDateTime.now());
        testPostTwo.setId(2L);
        testPostTwo.setContent("Test Content Two");
        testPostTwo.setTitle("Test Post Two");

        List<Post> posts = List.of(testPostOne, testPostTwo);

        when(postRepo.findAll()).thenReturn(posts);

        List<PostDTO> postDTOS = postService.getAllPosts();

        //Ensure return list is the same size of input
        assertEquals(postDTOS.size(), posts.size());

        for (int i = 0; i < posts.size(); i++) {
            assertEquals(posts.get(i).getTitle(), postDTOS.get(i).getTitle());
            assertEquals(posts.get(i).getAuthor().getId(), postDTOS.get(i).getAuthorId());
            assertEquals(posts.get(i).getContent(), postDTOS.get(i).getContent());
            assertEquals(posts.get(i).getId(), postDTOS.get(i).getId());
        }
    }

    @Test
    @DisplayName("Test 3: Retrieve post by Id")
    public void retrieveAuthorById() {
        Author testAuthor = new Author(1L, "Hippo", "easy1123@gmail.com");

        //Post One
        Post testPostOne = new Post();
        testPostOne.setAuthor(testAuthor);
        testPostOne.setCreatedAt(LocalDateTime.now());
        testPostOne.setId(1L);
        testPostOne.setContent("Test Content");
        testPostOne.setTitle("Test Post");

        when(postRepo.findById(1L)).thenReturn(Optional.of(testPostOne));

        PostDTO result = postService.getPostById(1L);

        assertAll("post",
                () -> assertEquals(result.getTitle(), testPostOne.getTitle()),
                () -> assertEquals(result.getId(), testPostOne.getId()),
                () -> assertEquals(result.getContent(), testPostOne.getContent()),
                () -> assertEquals(result.getCreatedAt(), testPostOne.getCreatedAt())
        );
    }


    @Test
    @DisplayName("Test 4: Delete post by Id")
    public void deleteAuthorById() {
        Author testAuthor = new Author(1L, "Hippo", "easy1123@gmail.com");

        //Post One
        Post testPostOne = new Post();
        testPostOne.setAuthor(testAuthor);
        testPostOne.setCreatedAt(LocalDateTime.now());
        testPostOne.setId(1L);
        testPostOne.setContent("Test Content");
        testPostOne.setTitle("Test Post");


        when(postRepo.findById(1L)).thenReturn(Optional.of(testPostOne));

        postService.deletePost(1L);

        verify(postRepo).deleteById(1L);
    }
}
