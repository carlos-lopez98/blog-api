package com.blogplatform.blogapi.mapper;


import com.blogplatform.blogapi.dto.AuthorDTO;
import com.blogplatform.blogapi.model.Author;
import lombok.experimental.UtilityClass;

/**
 * Mapper class used to map AuthorDTO to Author and vice versa
 *
 * @Author CJL
 */

@UtilityClass
public class AuthorMapper {

    public static AuthorDTO toDTO(Author entity){
        return new AuthorDTO(entity.getId(), entity.getName(), entity.getEmail());
    }

    public static Author toAuthor(AuthorDTO dto){
        return new Author(dto.getId(), dto.getName(), dto.getEmail());
    }
}
