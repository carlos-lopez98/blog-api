package com.blogplatform.blogapi.dto;

import com.blogplatform.blogapi.model.Post;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

/**
 * CommentDTO used to decouple response/ request from Comment Entity
 *
 * @Author CJL
 */
@Getter
@Setter
@ToString
@Builder
public class CommentDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String content;

    @NotBlank
    private String posterName;

    @NotNull
    private Long postId;

    @NotNull
    private LocalDateTime createdAt;

    public CommentDTO(Long id, String content, String posterName, Long postId, LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.posterName = posterName;
        this.postId = postId;
        this.createdAt = createdAt;
    }

    public CommentDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
