package com.blogplatform.blogapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Model Entity for a post
 * Relationship @ManyToOne w/ Author
 *
 * @Author CJL
 */
@Getter
@NoArgsConstructor
@Setter
@Entity
@Table(name = "post")
@ToString(includeFieldNames = false)
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "title", nullable = false)
    private String title;

    @Column (name = "content", nullable = false)
    private String content;
    @Column (name = "createdAt")
    private LocalDateTime createdAt;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

}
