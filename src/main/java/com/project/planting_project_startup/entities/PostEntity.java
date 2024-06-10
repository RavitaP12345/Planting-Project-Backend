package com.project.planting_project_startup.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "post_details")
public class PostEntity extends SharedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long postId;
    private String postTitle;
    private String postContent;
    private String postImage;
    private String location;
    private String longitude;
    private String latitude;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity user;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<CommentEntity> comments;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<LikeDislikeEntity> likeDislikes;

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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    public List<LikeDislikeEntity> getLikeDislikes() {
        return likeDislikes;
    }

    public void setLikeDislikes(List<LikeDislikeEntity> likeDislikes) {
        this.likeDislikes = likeDislikes;
    }
}
