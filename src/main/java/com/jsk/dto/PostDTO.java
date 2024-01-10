package com.jsk.dto;

public class PostDTO {

    private String UserId;
    private String PostBody;

    public PostDTO(){

    }

    public PostDTO(String userId, String postBody) {
        UserId = userId;
        PostBody = postBody;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPostBody() {
        return PostBody;
    }

    public void setPostBody(String postBody) {
        PostBody = postBody;
    }
}