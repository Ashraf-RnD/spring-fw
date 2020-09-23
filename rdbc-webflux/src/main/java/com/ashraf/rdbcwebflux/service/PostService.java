package com.ashraf.rdbcwebflux.service;

import com.ashraf.rdbcwebflux.entity.Post;
import com.ashraf.rdbcwebflux.request.PostRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {
    Mono<Post> savePost(PostRequest request);
    Mono<Post> getPostById(int id);
    Flux<Post> getAllPost();
}
