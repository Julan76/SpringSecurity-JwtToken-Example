package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RequestMapping("${info.api.base-path}" + "/post")
@RestController
public class PostController {
    PostRepository postRepository;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        postRepository.save(post);
        return  new ResponseEntity<>(post, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Post> updatePost(@RequestBody Post post){
        Post postToUpdate=postRepository.findOne(post.getId());
        postToUpdate.setTitle(post.getTitle());
        postToUpdate.setDescription(post.getDescription());
        postToUpdate.setEditDate(LocalDateTime.now());
        return new ResponseEntity<Post>(post,HttpStatus.OK);
    }
}
