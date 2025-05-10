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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
