package com.blogplatform.blogapi.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

/**
 * PostDTO used to decouple response/ request from Post Entity
 *
 * @Author CJL
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(includeFieldNames = false)
@Builder
public class PostDTO {

    @NotNull
    private long id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    private LocalDateTime createdAt;

    @NotBlank
    private Long authorId;
}
