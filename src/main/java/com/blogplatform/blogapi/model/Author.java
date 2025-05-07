package com.blogplatform.blogapi.model;

import jakarta.persistence.*;
import lombok.*;

/**
 *  Model object for an author of Blog
 *
 * @Author CJL
 */
@Entity
@Getter
@Setter
@Table(name = "author")
@ToString(includeFieldNames = false)
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name", nullable = false)
    private String name;

    @Column (name = "email", nullable = false, unique = true)
    private String email;
}
