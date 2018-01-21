package com.example.demo.els.Impl;

import com.example.demo.domain.els.Post;
import com.example.demo.els.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostImpl {
 private PostRepository postRepository;
    @Autowired
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public Post save(Post post){
        return  postRepository.save(post);
    }
}
