package com.example.demo.els.repository;

import com.example.demo.domain.els.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PostRepository extends ElasticsearchRepository<Post, Long> {
}
