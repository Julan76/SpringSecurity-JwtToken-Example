package com.example.demo.controller;

import com.example.demo.domain.els.Post;
import com.example.demo.els.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("${info.api.base-path}" + "/post")
@RestController
public class PostController {
    @Autowired
    private ElasticsearchTemplate esTemplate;
    @Autowired
    private PostRepository postRepository;

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> createPost(@RequestBody Post post) {
        createIndex();
        postRepository.save(post);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.PUT)
    @PreAuthorize("hasRole('ROLE_USER')")
    public void updatePost(@RequestBody Post post) {
        postRepository.save(post); }

    public void createIndex() {
        esTemplate.createIndex(Post.class);
        esTemplate.putMapping(Post.class);
        esTemplate.refresh(Post.class);
    }
}