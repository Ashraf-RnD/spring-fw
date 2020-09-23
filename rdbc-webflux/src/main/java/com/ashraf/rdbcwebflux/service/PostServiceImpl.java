package com.ashraf.rdbcwebflux.service;

import com.ashraf.rdbcwebflux.entity.Post;
import com.ashraf.rdbcwebflux.repository.PostRepository;
import com.ashraf.rdbcwebflux.request.PostRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Mono<Post> savePost(PostRequest request) {
        return postRepository.save(Post.builder().title(request.getTitle()).content(request.getContent()).build());
    }

    @Override
    public Mono<Post> getPostById(int id) {
        return postRepository.findById(id);
    }

    @Override
    public Flux<Post> getAllPost() {
        return postRepository.findAll();
    }
}
