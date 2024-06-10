package com.project.planting_project_startup.models;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PostModel extends SharedModel{
    private Long postId;
    @NotNull(message = "Title must nut be null.")
    @NotBlank(message = "Title must not be blank.")
    private String postTitle;
    @NotNull(message = "Content must not be null.")
    @NotBlank(message = "Content must not be blank.")
    private String postContent;
    @NotNull(message = "Image must not be null.")
    @NotBlank(message = "Image must not be blank.")
    private String postImage;
    @NotNull(message = "Location must not be null.")
    @NotBlank(message = "Location must not be blank.")
    private String location;
    @NotNull(message = "Longitude must not be null.")
    @NotBlank(message = "Longitude must not be blank.")
    private String longitude;
    @NotNull(message = "Latitude must not be null.")
    @NotBlank(message = "Latitude must not be blank.")
    private String latitude;
    @NotNull(message = "User id must not be null.")
    @NotBlank(message = "User id must not be blank.")
    private String userId;
    private List<CommentModel> comments;
    private List<LikeDislikeModel> likeDislikes;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<CommentModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }

    public List<LikeDislikeModel> getLikeDislikes() {
        return likeDislikes;
    }

    public void setLikeDislikes(List<LikeDislikeModel> likeDislikes) {
        this.likeDislikes = likeDislikes;
    }
}
