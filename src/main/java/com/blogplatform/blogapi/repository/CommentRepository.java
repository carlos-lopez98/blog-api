package com.blogplatform.blogapi.repository;

import com.blogplatform.blogapi.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
