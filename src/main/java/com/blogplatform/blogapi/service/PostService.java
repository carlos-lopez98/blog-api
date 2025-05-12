package com.blogplatform.blogapi.service;

import com.blogplatform.blogapi.dto.PostDTO;

import java.util.List;


/**
 * Interface used for PostService
 *
 * @Author CJL
 */
public interface PostService {

    PostDTO createPost(PostDTO dto);

    List<PostDTO> getAllPosts();
    PostDTO getPostById(Long id);

    void deletePost(Long id);
}
