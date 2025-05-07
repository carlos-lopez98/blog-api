package com.blogplatform.blogapi.mapper;

import com.blogplatform.blogapi.dto.PostDTO;
import com.blogplatform.blogapi.model.Author;
import com.blogplatform.blogapi.model.Post;
import lombok.experimental.UtilityClass;

/**
 * Mapper class used to map PostDTO to Post and vice versa
 *
 * @Author CJL
 */

@UtilityClass
public class PostMapper {

    public static PostDTO toDTO(Post entity){
        return new PostDTO(entity.getId(), entity.getTitle(), entity.getContent(), entity.getCreatedAt(), entity.getAuthor().getId());
    }

    public static Post toPost(PostDTO dto){
        Author temp = new Author();
        temp.setId(dto.getAuthorId());

        return new Post(dto.getId(), dto.getTitle(),dto.getContent(), dto.getCreatedAt(), temp);
    }
}
