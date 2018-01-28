package com.example.demo.domain.els;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

@Document(indexName = "app", type = "comments")
@AllArgsConstructor
public class Comment {
    private Long id; //authorId+localDateTime
    private String text;
    private Timestamp date;
    private UserEls authorComment;

    public Comment( String text, Timestamp date, UserEls authorComment) {
        this.text = text;
        this.date = date;
        this.authorComment = authorComment;
        this.id = generateIdhashCode();
    }

    public Long generateIdhashCode() {
        return Long.valueOf(Math.abs(Objects.hash(super.hashCode(), date, authorComment.getId())));
    }
}
