package com.blogplatform.blogapi.service;

import com.blogplatform.blogapi.dto.AuthorDTO;
import com.blogplatform.blogapi.mapper.AuthorMapper;
import com.blogplatform.blogapi.model.Author;
import com.blogplatform.blogapi.repository.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for the Author Service
 *
 * @Author CJL
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepo;

    @Autowired
    AuthorServiceImpl(AuthorRepository authorRepository){
        this.authorRepo = authorRepository;
    }

    /**
     * Creates a new author in the database
     *
     * @param dto the author data to be created
     * @return the created author as a DTO
     */
    @Override
    public AuthorDTO createAuthor(AuthorDTO dto) {
        Author saved = authorRepo.save(AuthorMapper.toAuthor(dto));

      return AuthorMapper.toDTO(saved);
    }

    /**
     * Retrieves a list of all available authors in the database
     *
     * @return list of authors
     */
    @Override
    public List<AuthorDTO> getAllAuthors() {
        return authorRepo.findAll().stream().map(AuthorMapper::toDTO).collect(Collectors.toList());
    }

    /**
     * Retrieves an author by its respective id
     *
     * @param id Unique identifier for each author
     * @return an author as a DTO
     */
    //TODO: Create Custom Exception to handle not Found Error
    @Override
    public AuthorDTO getAuthorById(Long id) {
        Author author = authorRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Author Not Found with ID: " + id));
        return AuthorMapper.toDTO(author);
    }

    /**
     * Deletes an author by its respective id
     *
     * @param id Unique identifier for each author
     */
    //TODO: Create Custom Exception to handle not Found Error
    @Override
    public void deleteAuthor(Long id) {
        authorRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Cannot delete Author — no record found with ID: " + id));

        authorRepo.deleteById(id);
    }
}
