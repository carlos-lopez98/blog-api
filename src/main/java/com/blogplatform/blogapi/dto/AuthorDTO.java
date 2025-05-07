package com.blogplatform.blogapi.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * AuthorDTO used to decouple response from Author Entity
 *
 * @Author CJL
 */

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString (includeFieldNames = false)
@Builder
public class AuthorDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

}
