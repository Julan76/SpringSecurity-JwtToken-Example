package com.example.demo.domain.els;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(indexName = "app", type = "posts")
public class Post {
    @Id
    private Long id;
    private String title;
    private String description;
    private LocalDate publicationDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private UserEls authorPost;
    private List<Comment>comments;
}
