package com.blogplatform.blogapi.mapper;

import com.blogplatform.blogapi.dto.CommentDTO;
import com.blogplatform.blogapi.model.Comment;
import com.blogplatform.blogapi.model.Post;
import lombok.experimental.UtilityClass;

/**
 * Mapper class used to map CommentDTO to Comment Entity and vice versa
 *
 * @Author CJL
 */

@UtilityClass
public class CommentMapper {

    public static CommentDTO toDTO(Comment entity){
        return new CommentDTO(entity.getId(), entity.getContent(), entity.getPosterName(), entity.getPost().getId(), entity.getCreatedAt());
    }

    public static Comment toComment(CommentDTO dto){
        Post temp = new Post();
        temp.setId(dto.getPostId());

        return new Comment(dto.getId(), dto.getContent(), dto.getPosterName(), temp, dto.getCreatedAt());
    }
}
