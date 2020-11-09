package com.ashraf.rdbcwebflux.repository;

import com.ashraf.rdbcwebflux.entity.Post;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends ReactiveCrudRepository<Post,Integer> {
}
