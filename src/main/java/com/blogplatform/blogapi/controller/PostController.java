package com.blogplatform.blogapi.controller;

import com.blogplatform.blogapi.dto.PostDTO;
import com.blogplatform.blogapi.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * Inserts a post into the database
     *
     * @param dto
     * @return the created post
     */
    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostDTO dto){
        PostDTO created;

     try{
         created = postService.createPost(dto);
         return ResponseEntity.status(HttpStatus.CREATED).body(created);
     }catch (EntityNotFoundException e){
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to create post: required entity not found. Author by id " + dto.getAuthorId());
     }
    }




    /**
     * Returns post information by respective Id
     *
     * @param id
     * @return response entity postEntity
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){

        PostDTO retrieved;

        try{
            retrieved =  postService.getPostById(id);
            return ResponseEntity.ok(retrieved);
        } catch(EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID: " + id + "not found");
        }
    }


    /**
     * Returns all posts in database
     *
     * @return list of all posts
     */
    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts(){

        return ResponseEntity.ok(postService.getAllPosts());
    }


    /**
     * Deletes the author by the respective Id
     *
     * @param id
     * @return Successful deletion message
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){

        try{
            postService.deletePost(id);
            return ResponseEntity.ok("Post Successfully Deleted");
        }catch(EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID: " + id + " not found");
        }
    }

}
