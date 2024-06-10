package com.project.planting_project_startup.models;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LikeDislikeModel extends SharedModel{
    private Long actionId;
    @NotNull(message = "Action type must not be null.")
    @NotBlank(message = "Action type must not be blank.")
    private String actionType;//it will be like or dislike
    @NotNull(message = "User id must not be null.")
    @NotBlank(message = "User id must nu be blank.")
    private String userId;
    @NotNull(message = "Post id must not be null.")
    @NotBlank(message = "Post id must nu be blank.")
    private String postId;

    public Long getActionId() {
        return actionId;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
