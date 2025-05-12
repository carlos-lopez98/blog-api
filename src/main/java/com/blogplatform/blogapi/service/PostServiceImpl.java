package com.blogplatform.blogapi.service;

import com.blogplatform.blogapi.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Implementation for the PostService Interface
 *
 * @Author CJL
 */
@Service
public class PostServiceImpl implements PostService {



    @Override
    public PostDTO createPost(PostDTO dto) {


        return null;
    }

    @Override
    public List<PostDTO> getAllPosts() {
        return null;
    }

    @Override
    public PostDTO getPostById(Long id) {
        return null;
    }

    @Override
    public void deletePost(Long id) {

    }
}
