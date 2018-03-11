package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDate publicationDate;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private User authorPost;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="POST_COMMENTS")
    private Set<Comment> comments;
}
