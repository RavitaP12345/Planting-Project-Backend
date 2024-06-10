package com.project.planting_project_startup.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "comment_details")
public class CommentEntity extends SharedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long commentId;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;
    private String userId;

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

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
