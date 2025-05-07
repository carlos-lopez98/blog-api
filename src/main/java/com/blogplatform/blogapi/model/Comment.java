package com.blogplatform.blogapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Model Entity for a comment
 * Relationship @ManyToOne w/ Post
 *
 * @Author CJL
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "comment")
@ToString(includeFieldNames = false, exclude = "post")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "poster_name", nullable = false)
    private String posterName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column (name = "createdAt")
    private LocalDateTime createdAt;
}
