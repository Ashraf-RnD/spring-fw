package com.ashraf.rdbcwebflux.controller;

import com.ashraf.rdbcwebflux.entity.Post;
import com.ashraf.rdbcwebflux.request.PostRequest;
import com.ashraf.rdbcwebflux.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(value = "/createPost")
    public Mono<Post> createPost(@RequestBody PostRequest request){
        return postService.savePost(request);
    }

    @GetMapping("/getPostById")
    public Mono<Post> getPostById(int postId) {
        return postService.getPostById(postId);
    }

    @GetMapping("/getAllPosts")
    public Flux<Post> getAllPosts() {
        return postService.getAllPost();
    }
}
