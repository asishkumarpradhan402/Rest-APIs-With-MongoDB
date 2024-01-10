package com.jsk.dto;

public class DTO {
    private int postId;
    private String searchText;
    private String subscriber;

    public DTO(){

    }

    public DTO(int postId, String searchText, String subscriber) {
        this.postId = postId;
        this.searchText = searchText;
        this.subscriber = subscriber;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }
}