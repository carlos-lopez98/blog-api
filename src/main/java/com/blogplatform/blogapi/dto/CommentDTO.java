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
@NoArgsConstructor
@AllArgsConstructor
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
}
