package com.project.planting_project_startup.models;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CommentModel extends SharedModel{
    private Long commentId;
    @NotNull(message = "Comment must not be null.")
    @NotBlank(message = "Comment must not be blank.")
    private String comment;
    @NotNull(message = "User id must not be null.")
    @NotBlank(message = "User id must not be blank.")
    private String userId;
    @NotNull(message = "Post id must not be null.")
    @NotBlank(message = "Post id must not be blank.")
    private String postId;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
