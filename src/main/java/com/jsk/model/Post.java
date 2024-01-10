package com.jsk.model;

public class Post {
    private int postId;
    private String postBody;
    private String postDate;

    public Post() {
    }

    public Post(int postId, String postBody, String postDate) {
        this.postId = postId;
        this.postBody = postBody;
        this.postDate = postDate;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }
}
