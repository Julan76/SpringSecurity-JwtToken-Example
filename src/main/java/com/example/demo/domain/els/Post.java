package com.example.demo.domain.els;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Data
@Document(indexName = "app", type = "posts")
@AllArgsConstructor
public class Post {

    private Long id; //id User+LocalDateTime
    private String title;
    private String description;
    private Timestamp publicationDate;
    private Timestamp startDate;
    private Timestamp endDate;
    private UserEls authorPost;
    private List<Comment>comments;


    public Post(String title, String description, Timestamp publicationDate, Timestamp startDate, Timestamp endDate, UserEls authorPost, List<Comment> comments) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.authorPost = authorPost;
        this.id = generateIdhashCode();
        this.comments = comments;
    }

    public Long generateIdhashCode() {

        return Long.valueOf(Math.abs(Objects.hash(super.hashCode(), publicationDate, authorPost.getId())));
    }
}
