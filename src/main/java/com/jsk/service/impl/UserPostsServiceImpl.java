package com.jsk.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsk.dto.DTO;
import com.jsk.dto.PostDTO;
import com.jsk.model.Post;
import com.jsk.model.UserPosts;
import com.jsk.repository.UserPostsRepo;
import com.jsk.service.UserPostsService;

@Service
public class UserPostsServiceImpl implements UserPostsService {

	private static int id = 1;

	private int generateId() {
		return id++;
	}

	@Autowired
	private UserPostsRepo userPostsRepo;

	@Override
	public UserPosts addPost(PostDTO postDTO) {
		UserPosts userPosts = new UserPosts();
		userPosts.setUserId(postDTO.getUserId());
		List<Post> listOfPosts = new ArrayList<>();
		Post post = new Post();
		post.setPostId(generateId());
		post.setPostBody(postDTO.getPostBody());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		post.setPostDate(sdf.format(new Date()));
		listOfPosts.add(post);
		userPosts.setPosts(listOfPosts);

		List<String> listOfSubscribed = new ArrayList<>();
		userPosts.setSubscribed(listOfSubscribed);

		UserPosts saved = userPostsRepo.save(userPosts);
		return saved;
	}

	@Override
	public List<Post> getPost(String userId) {
		Optional<UserPosts> data = userPostsRepo.findById(userId);
		if (data.isPresent()) {
			UserPosts userPosts = data.get();
			List<Post> listOfPosts = userPosts.getPosts();
			if (listOfPosts == null || listOfPosts.isEmpty()) {
				return null;
			}
			return listOfPosts;
		} else {
			return null;
		}
	}

	@Override
	public Boolean delPost(String userId, DTO dTO) {
		Optional<UserPosts> data = userPostsRepo.findById(userId);
		if (data.isPresent()) {
			UserPosts userPosts = data.get();
			List<Post> listOfPosts = userPosts.getPosts();
			if (listOfPosts == null || listOfPosts.isEmpty()) {
				return false;
			}
			int postId = dTO.getPostId();
			List<Post> newPostList = new ArrayList<>();
			for (Post post : listOfPosts) {
				if (post.getPostId() == postId) {
					continue;
				}
				newPostList.add(post);
			}
			if (listOfPosts.size() == newPostList.size()) {
				return false;
			}
			userPosts.setPosts(newPostList);
			userPostsRepo.save(userPosts);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Post> searchPost(String userId, DTO dTO) {
		Optional<UserPosts> data = userPostsRepo.findById(userId);
		if (data.isPresent()) {
			UserPosts userPosts = data.get();
			List<Post> listOfPosts = userPosts.getPosts();
			if (listOfPosts == null || listOfPosts.isEmpty()) {
				return null;
			}
			String searchText = dTO.getSearchText();
			List<Post> newPostList = new ArrayList<>();
			for (Post post : listOfPosts) {
				if (!post.getPostBody().contains(searchText)) {
					continue;
				}
				newPostList.add(post);
			}
			if (newPostList.isEmpty()) {
				return null;
			}
			return newPostList;
		} else {
			return null;
		}
	}

	@Override
	public UserPosts subscribe(String userId, DTO dTO) {
		Optional<UserPosts> data = userPostsRepo.findById(userId);
		if (data.isPresent()) {
			UserPosts userPosts = data.get();
			List<String> subscribeList = userPosts.getSubscribed();
			if (subscribeList == null || subscribeList.isEmpty()) {
				subscribeList = new ArrayList<>();
			}
			subscribeList.add(dTO.getSubscriber());
			userPosts.setSubscribed(subscribeList);
			UserPosts saved = userPostsRepo.save(userPosts);
			return saved;
		} else {
			return null;
		}
	}

	@Override
	public List<Post> getPostById(String userId) {
		Optional<UserPosts> data = userPostsRepo.findByUserId(userId);
		if (data.isPresent()) {
			UserPosts userPosts = data.get();
			List<Post> listOfPosts = userPosts.getPosts();
			if (listOfPosts == null || listOfPosts.isEmpty()) {
				return null;
			}
			return listOfPosts;
		} else {
			return null;
		}
	}
	
	@Override
	public List<Post> getPostDetails(String userId) {
		Optional<UserPosts> data = userPostsRepo.findPostsByUserId(userId);
		if (data.isPresent()) {
			UserPosts userPosts = data.get();
			List<Post> listOfPosts = userPosts.getPosts();
			if (listOfPosts == null || listOfPosts.isEmpty()) {
				return null;
			}
			return listOfPosts;
		} else {
			return null;
		}
	}
}
