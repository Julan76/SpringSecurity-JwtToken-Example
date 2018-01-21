package com.example.demo.domain.els;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Document(indexName = "app", type = "users")
@Data
public class UserEls {
    @Id
    private String id;
    @Setter
    private String name;
}
