package com.example.demo.domain;
import lombok.Data;


import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String text;
    private LocalDateTime publicationDate;
    private LocalDateTime editDate;
    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private User authorComment;
}
