package com.blogplatform.blogapi.controller;

import com.blogplatform.blogapi.dto.AuthorDTO;
import com.blogplatform.blogapi.repository.AuthorRepository;
import com.blogplatform.blogapi.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.RequestHeaderMapMethodArgumentResolver;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorService;


    @PostMapping
    public ResponseEntity createAuthor(@RequestBody AuthorDTO dto){

        AuthorDTO created = authorService.createAuthor(dto);

        return ResponseEntity.ok("Succesfully created" + created.getName());
    }

    @GetMapping("/id")
    public ResponseEntity<AuthorDTO> getById(@PathVariable Long id){

        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AuthorDTO>> getAllAuthors(){

        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @DeleteMapping("/id")
    public ResponseEntity deleteById(@PathVariable Long id){
        authorService.deleteAuthor(id);

        return ResponseEntity.ok("Author Successfully Deleted");
    }
}
