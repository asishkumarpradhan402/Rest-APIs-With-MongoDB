package com.jsk.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userposts")
public class UserPosts {

    @Id
    private String userId;
    private List<Post> posts;
    private List<String> subscribed;

    public UserPosts(){

    }

    public UserPosts(String userId, List<Post> posts, List<String> subscribed) {
        this.userId = userId;
        this.posts = posts;
        this.subscribed = subscribed;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<String> getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(List<String> subscribed) {
        this.subscribed = subscribed;
    }

    @Override
    public String toString() {
        return "UserPostsRepo{" +
                "userId='" + userId + '\'' +
                ", posts=" + posts +
                ", subscribed=" + subscribed +
                '}';
    }
}
