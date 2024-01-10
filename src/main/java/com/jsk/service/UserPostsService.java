package com.jsk.service;

import java.util.List;

import com.jsk.dto.DTO;
import com.jsk.dto.PostDTO;
import com.jsk.model.Post;
import com.jsk.model.UserPosts;

public interface UserPostsService {

	UserPosts addPost(PostDTO postDTO);

	List<Post> getPost(String userId);
	
	List<Post> getPostById(String userId);
	
	List<Post> getPostDetails(String userId);

	Boolean delPost(String userId, DTO dTO);

	List<Post> searchPost(String userId, DTO dTO);

	UserPosts subscribe(String userId, DTO dTO);

}
