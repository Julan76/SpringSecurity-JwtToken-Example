package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime publicationDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime editDate;
    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private User authorPost;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="POST_COMMENTS")
    private Set<Comment> comments;
}
