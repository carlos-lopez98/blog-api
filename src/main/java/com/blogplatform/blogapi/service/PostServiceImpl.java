package com.blogplatform.blogapi.service;

import com.blogplatform.blogapi.dto.PostDTO;
import com.blogplatform.blogapi.mapper.PostMapper;
import com.blogplatform.blogapi.model.Author;
import com.blogplatform.blogapi.model.Post;
import com.blogplatform.blogapi.repository.AuthorRepository;
import com.blogplatform.blogapi.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for the PostService Interface
 *
 * @Author CJL
 */
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepo;
    private final AuthorRepository authorRepo;
    @Autowired
    PostServiceImpl(PostRepository postRepo, AuthorRepository authorRepo){
        this.postRepo = postRepo;
        this.authorRepo = authorRepo;
    }

    /**
     * Creates a new post in the database
     *
     * @param dto the post data to be created
     * @return the created post as a DTO
     */
    @Override
    public PostDTO createPost(PostDTO dto) {
        Author author = authorRepo.findById(dto.getAuthorId())
                .orElseThrow(() -> new EntityNotFoundException("Unable to create Post - Author Id not in database " + dto.getAuthorId()));

        Post post = PostMapper.toPost(dto);
        post.setAuthor(author);

        Post saved = postRepo.save(post);
        return PostMapper.toDTO(saved);
    }

    /**
     * Retrieves a list of all available posts in the database
     *
     * @return list of posts
     */
    @Override
    public List<PostDTO> getAllPosts() {
        return postRepo.findAll().stream().map(PostMapper:: toDTO).collect(Collectors.toList());
    }

    /**
     * Retrieves a post by its respective id
     *
     * @param id Unique identifier for each post
     * @return a post as a DTO
     */
    //TODO: Create Custom Exception to handle not Found Error
    @Override
    public PostDTO getPostById(Long id) {

        Post post = postRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Post not found with ID: " + id));

        return PostMapper.toDTO(post);
    }

    /**
     * Deletes a post by its respective id
     *
     * @param id Unique identifier for each post
     */
    //TODO: Create Custom Exception to handle not Found Error
    @Override
    public void deletePost(Long id) {
        postRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Cannot delete Post — no record found with ID: " + id));
        postRepo.deleteById(id);
    }
}
