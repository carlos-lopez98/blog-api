package com.blogplatform.blogapi.controller;

import com.blogplatform.blogapi.dto.AuthorDTO;
import com.blogplatform.blogapi.service.AuthorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController handling HTTP methods for Author
 *
 * @Author CJL
 */
//TODO: @ControllerAdvice + @ExceptionHandler
//TODO: Implement Custom Exceptions - AuthorNotFoundException
@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    /**
     * Inserts author into database
     *
     * @param dto
     * @return the author created
     */
    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO dto){

        AuthorDTO created = authorService.createAuthor(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * Returns author information by respective Id
     *
     * @param id
     * @return response entity AuthorDTO
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){

        AuthorDTO retrieved;

        try{
            retrieved =  authorService.getAuthorById(id);
            return ResponseEntity.ok(retrieved);
        } catch(EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID: " + id + "not found");
        }
    }


    /**
     * Returns all authors in database
     *
     * @return list of all authors
     */
    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors(){

        return ResponseEntity.ok(authorService.getAllAuthors());
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
            authorService.deleteAuthor(id);
            return ResponseEntity.ok("Author Successfully Deleted");
        }catch(EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID: " + id + " not found");
        }
    }
}
