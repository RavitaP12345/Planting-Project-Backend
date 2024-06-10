package com.project.planting_project_startup.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "like_dislike_details")
public class LikeDislikeEntity extends SharedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long actionId;
    private String actionType; //it will be like or dislike
    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;
    private String userId;

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
