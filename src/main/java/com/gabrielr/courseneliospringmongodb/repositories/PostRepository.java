package com.gabrielr.courseneliospringmongodb.repositories;

import com.gabrielr.courseneliospringmongodb.domain.Post;
import com.gabrielr.courseneliospringmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
