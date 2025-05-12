package com.blogplatform.blogapi.service;

import com.blogplatform.blogapi.dto.AuthorDTO;

import java.util.List;

/**
 * Interface used for AuthorService
 *
 * @Author CJL
 */
public interface AuthorService {

    AuthorDTO createAuthor(AuthorDTO dto);
    List<AuthorDTO> getAllAuthors();

    AuthorDTO getAuthorByID(Long id);

    void deleteAuthor(Long id);

}
