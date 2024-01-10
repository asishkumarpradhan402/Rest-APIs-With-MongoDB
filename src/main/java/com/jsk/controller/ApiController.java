package com.jsk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsk.dto.DTO;
import com.jsk.dto.PostDTO;
import com.jsk.model.Post;
import com.jsk.model.UserPosts;
import com.jsk.service.UserPostsService;

@RestController
public class ApiController {

	@Autowired
	private UserPostsService userPostsService;
	
    @PostMapping("addpost")
    public ResponseEntity<Object> addPost(
        @RequestBody PostDTO postDTO) {
        UserPosts saved = userPostsService.addPost(postDTO);
        return new ResponseEntity<Object>(saved, HttpStatus.CREATED);
    }


    @GetMapping("/getpost/{userId}")
    public ResponseEntity<Object> getPost(
        @PathVariable("userId") String userId) {
    	List<Post> listOfPosts = userPostsService.getPost(userId);
        if(listOfPosts != null){
            return new ResponseEntity<Object>(listOfPosts, HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/getpostbyid/{userId}")
    public ResponseEntity<Object> getPostById(
        @PathVariable("userId") String userId) {
    	List<Post> listOfPosts = userPostsService.getPostById(userId);
        if(listOfPosts != null){
            return new ResponseEntity<Object>(listOfPosts, HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/getpostbyid")
    public ResponseEntity<Object> getPostDetails(
        @RequestParam("userId") String userId) {
    	List<Post> listOfPosts = userPostsService.getPostDetails(userId);
        if(listOfPosts != null){
            return new ResponseEntity<Object>(listOfPosts, HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delpost/{userId}")
    public ResponseEntity<Object> delPost(
         @PathVariable("userId") String userId, 
         @RequestBody DTO dTO) {
        Boolean delPost = userPostsService.delPost(userId, dTO);
        if(delPost){
            return new ResponseEntity<Object>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/searchpost/{userId}")
    public ResponseEntity<Object> searchPost(
        @PathVariable("userId") String userId, 
        @RequestBody DTO dTO) {
        List<Post> data = userPostsService.searchPost(userId, dTO);
        if(data != null){
            return new ResponseEntity<Object>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/subscribe/{userId}")
    public ResponseEntity<Object> subscribe(
        @PathVariable("userId") String userId, 
        @RequestBody DTO dTO) {
        UserPosts subscribeUpdate = userPostsService.subscribe(userId, dTO);
        if(subscribeUpdate != null){
            return new ResponseEntity<Object>(subscribeUpdate, HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
    }

}
