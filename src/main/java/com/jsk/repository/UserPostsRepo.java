package com.jsk.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.jsk.model.UserPosts;


@Repository
public interface UserPostsRepo extends MongoRepository<UserPosts, String> {
	
	@Query(value = "{ '_id' : ?0 }")
	Optional<UserPosts> findByUserId(String userId);
	
	@Query(value = "{ '_id' : ?0 }", fields = "{ 'posts.postId' : 1, 'posts.postBody': 1 }")
	Optional<UserPosts> findPostsByUserId(String userId);
}
