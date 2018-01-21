package com.example.demo.domain.els;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDate;

@Document(indexName = "app", type = "comments")
public class Comment {
    @Id
    private Long id;
    private String text;
    private LocalDate date;
    private UserEls authorComment;
}
