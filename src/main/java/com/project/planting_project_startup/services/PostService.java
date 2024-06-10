package com.project.planting_project_startup.services;

import com.project.planting_project_startup.entities.CommentEntity;
import com.project.planting_project_startup.entities.LikeDislikeEntity;
import com.project.planting_project_startup.entities.PostEntity;
import com.project.planting_project_startup.entities.UserEntity;
import com.project.planting_project_startup.models.ApiResponseModel;
import com.project.planting_project_startup.models.CommentModel;
import com.project.planting_project_startup.models.LikeDislikeModel;
import com.project.planting_project_startup.models.PostModel;
import com.project.planting_project_startup.repositories.CommentRepository;
import com.project.planting_project_startup.repositories.LikeDislikeRepository;
import com.project.planting_project_startup.repositories.PostRepository;
import com.project.planting_project_startup.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    LikeDislikeRepository likeDislikeRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserService userService;
    public ResponseEntity<ApiResponseModel> savePostDetails(PostModel postModel) {
        try{
            PostEntity postEntity = new PostEntity();
            postEntity.setPostContent(postModel.getPostContent());
            postEntity.setLatitude(postModel.getLatitude());
            postEntity.setPostImage(postModel.getPostImage());
            postEntity.setPostTitle(postModel.getPostTitle());
            postEntity.setLocation(postModel.getLocation());
            postEntity.setLongitude(postModel.getLongitude());
            UserEntity userEntity = userRepository.findByUserId(Long.valueOf(postModel.getUserId()));
            postEntity.setUser(userEntity);
            postEntity.setCreatedBy(String.valueOf(userEntity.getUserId()));
            postEntity.setUpdatedBy(String.valueOf(userEntity.getUserId()));
            postEntity.setCreatedDate(new Date());
            postEntity.setLastUpdateDate(new Date());
            postEntity.setStatus("Active");
            postRepository.save(postEntity);
            return new ResponseEntity<>(new ApiResponseModel("Success", "Saved successfully."), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponseModel("Failed", "Not Saved."), HttpStatus.FORBIDDEN);
        }


    }


    public List<PostModel> getAllActivePosts() {
        List<PostEntity> postEntities = postRepository.findAll().stream().filter(status -> status.getStatus().equalsIgnoreCase("Active")).toList();
        List<PostModel> postModels = new ArrayList<>();
        postEntities.forEach(data->{
            List<CommentModel> commentModels = new ArrayList<>();
            List<LikeDislikeModel> likeDislikeModels = new ArrayList<>();
            PostModel model = new PostModel();
            model.setLatitude(data.getLatitude());
            model.setLocation(data.getLocation());
            model.setPostContent(data.getPostContent());
            model.setPostImage(data.getPostImage());
            model.setPostId(data.getPostId());
            model.setPostTitle(data.getPostTitle());
            model.setUserId(String.valueOf(data.getUser().getUserId()));
            model.setStatus(data.getStatus());
            model.setCreatedBy(data.getCreatedBy());
            model.setLongitude(data.getLongitude());
            model.setUpdatedBy(data.getUpdatedBy());
            model.setLastUpdateDate(String.valueOf(data.getLastUpdateDate()));
            model.setCreatedDate(String.valueOf(data.getLastUpdateDate()));
            List<CommentEntity> commentEntities = commentRepository.findByPost(data);
            List<LikeDislikeEntity> likeDislikeEntities = likeDislikeRepository.findByPost(data);
            commentEntities.forEach(comment->{
                CommentModel commentModel = new CommentModel();
                commentModel.setCommentId(comment.getCommentId());
                commentModel.setPostId(String.valueOf(comment.getPost().getPostId()));
                commentModel.setCreatedBy(comment.getCreatedBy());
                commentModel.setUpdatedBy(comment.getUpdatedBy());
                commentModel.setCreatedDate(String.valueOf(comment.getCreatedDate()));
                commentModel.setLastUpdateDate(String.valueOf(comment.getLastUpdateDate()));
                commentModel.setStatus(comment.getStatus());
                commentModel.setComment(comment.getComment());
                commentModel.setUserId(comment.getUserId());
                commentModels.add(commentModel);
            });
            likeDislikeEntities.forEach(action->{
                LikeDislikeModel likeDislikeModel = new LikeDislikeModel();
                likeDislikeModel.setActionId(action.getActionId());
                likeDislikeModel.setActionType(action.getActionType());
                likeDislikeModel.setPostId(String.valueOf(action.getPost().getPostId()));
                likeDislikeModel.setCreatedBy(action.getCreatedBy());
                likeDislikeModel.setUpdatedBy(action.getUpdatedBy());
                likeDislikeModel.setCreatedDate(String.valueOf(action.getCreatedDate()));
                likeDislikeModel.setLastUpdateDate(String.valueOf(action.getLastUpdateDate()));
                likeDislikeModel.setStatus(action.getStatus());
                likeDislikeModel.setUserId(action.getUserId());
                likeDislikeModels.add(likeDislikeModel);
            });
            model.setComments(commentModels);
            model.setLikeDislikes(likeDislikeModels);
            postModels.add(model);
        });
        return postModels;
    }

    public List<PostModel> getAllActivePostsByUserId(String userId) {
        UserEntity user =  userRepository.findByUserId(Long.valueOf(userId));
        List<PostEntity> postEntities = postRepository.findByUser(user).stream().filter(status -> status.getStatus().equalsIgnoreCase("Active")).toList();
        List<PostModel> postModels = new ArrayList<>();
        postEntities.forEach(data->{
            List<CommentModel> commentModels = new ArrayList<>();
            List<LikeDislikeModel> likeDislikeModels = new ArrayList<>();
            PostModel model = new PostModel();
            model.setLatitude(data.getLatitude());
            model.setLocation(data.getLocation());
            model.setPostContent(data.getPostContent());
            model.setPostImage(data.getPostImage());
            model.setPostId(data.getPostId());
            model.setPostTitle(data.getPostTitle());
            model.setUserId(String.valueOf(data.getUser().getUserId()));
            model.setStatus(data.getStatus());
            model.setCreatedBy(data.getCreatedBy());
            model.setLongitude(data.getLongitude());
            model.setUpdatedBy(data.getUpdatedBy());
            model.setLastUpdateDate(String.valueOf(data.getLastUpdateDate()));
            model.setCreatedDate(String.valueOf(data.getLastUpdateDate()));
            List<CommentEntity> commentEntities = commentRepository.findByPost(data);
            List<LikeDislikeEntity> likeDislikeEntities = likeDislikeRepository.findByPost(data);
            commentEntities.forEach(comment->{
                CommentModel commentModel = new CommentModel();
                commentModel.setCommentId(comment.getCommentId());
                commentModel.setPostId(String.valueOf(comment.getPost().getPostId()));
                commentModel.setCreatedBy(comment.getCreatedBy());
                commentModel.setUpdatedBy(comment.getUpdatedBy());
                commentModel.setCreatedDate(String.valueOf(comment.getCreatedDate()));
                commentModel.setLastUpdateDate(String.valueOf(comment.getLastUpdateDate()));
                commentModel.setStatus(comment.getStatus());
                commentModel.setComment(comment.getComment());
                commentModel.setUserId(comment.getUserId());
                commentModels.add(commentModel);
            });
            likeDislikeEntities.forEach(action->{
                LikeDislikeModel likeDislikeModel = new LikeDislikeModel();
                likeDislikeModel.setActionId(action.getActionId());
                likeDislikeModel.setActionType(action.getActionType());
                likeDislikeModel.setPostId(String.valueOf(action.getPost().getPostId()));
                likeDislikeModel.setCreatedBy(action.getCreatedBy());
                likeDislikeModel.setUpdatedBy(action.getUpdatedBy());
                likeDislikeModel.setCreatedDate(String.valueOf(action.getCreatedDate()));
                likeDislikeModel.setLastUpdateDate(String.valueOf(action.getLastUpdateDate()));
                likeDislikeModel.setStatus(action.getStatus());
                likeDislikeModel.setUserId(action.getUserId());
                likeDislikeModels.add(likeDislikeModel);
            });
            model.setComments(commentModels);
            model.setLikeDislikes(likeDislikeModels);
            postModels.add(model);
        });
        return postModels;
    }
    @Transactional
    public ResponseEntity<ApiResponseModel> deletePostDetailsByPostId(String postId) {
        try{
            PostEntity postEntity = postRepository.findByPostId(Long.valueOf(postId));
            postEntity.setStatus("Inactive");
            List<CommentEntity> commentEntities = commentRepository.findByPost(postEntity);
            commentEntities.forEach(data->{
                data.setStatus("Inactive");
            });
            List<LikeDislikeEntity> likeDislikeEntities = likeDislikeRepository.findByPost(postEntity);
            likeDislikeEntities.forEach(data->{
                data.setStatus("Inactive");
            });
            commentRepository.saveAll(commentEntities);
            likeDislikeRepository.saveAll(likeDislikeEntities);
            postRepository.save(postEntity);
            return new ResponseEntity<>(new ApiResponseModel("Success", "Deleted successfully."), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponseModel("Failed", "Something went wrong."), HttpStatus.FORBIDDEN);
        }
    }

    public PostModel getPostDetailsByPostId(String postId) {
        PostEntity data = postRepository.findByPostId(Long.valueOf(postId));
        List<PostModel> postModels = new ArrayList<>();
            List<CommentModel> commentModels = new ArrayList<>();
            List<LikeDislikeModel> likeDislikeModels = new ArrayList<>();
            PostModel model = new PostModel();
            model.setLatitude(data.getLatitude());
            model.setLongitude(data.getLongitude());
            model.setLocation(data.getLocation());
            model.setPostContent(data.getPostContent());
            model.setPostImage(data.getPostImage());
            model.setPostId(data.getPostId());
            model.setPostTitle(data.getPostTitle());
            model.setUserId(String.valueOf(data.getUser().getUserId()));
            model.setStatus(data.getStatus());
            model.setCreatedBy(data.getCreatedBy());
            model.setUpdatedBy(data.getUpdatedBy());
            model.setLastUpdateDate(String.valueOf(data.getLastUpdateDate()));
            model.setCreatedDate(String.valueOf(data.getLastUpdateDate()));
            List<CommentEntity> commentEntities = commentRepository.findByPost(data);
            List<LikeDislikeEntity> likeDislikeEntities = likeDislikeRepository.findByPost(data);
            commentEntities.forEach(comment->{
                CommentModel commentModel = new CommentModel();
                commentModel.setCommentId(comment.getCommentId());
                commentModel.setPostId(String.valueOf(comment.getPost().getPostId()));
                commentModel.setCreatedBy(comment.getCreatedBy());
                commentModel.setUpdatedBy(comment.getUpdatedBy());
                commentModel.setCreatedDate(String.valueOf(comment.getCreatedDate()));
                commentModel.setLastUpdateDate(String.valueOf(comment.getLastUpdateDate()));
                commentModel.setStatus(comment.getStatus());
                commentModel.setComment(comment.getComment());
                commentModel.setUserId(comment.getUserId());
                commentModels.add(commentModel);
            });
            likeDislikeEntities.forEach(action->{
                LikeDislikeModel likeDislikeModel = new LikeDislikeModel();
                likeDislikeModel.setActionId(action.getActionId());
                likeDislikeModel.setActionType(action.getActionType());
                likeDislikeModel.setPostId(String.valueOf(action.getPost().getPostId()));
                likeDislikeModel.setCreatedBy(action.getCreatedBy());
                likeDislikeModel.setUpdatedBy(action.getUpdatedBy());
                likeDislikeModel.setCreatedDate(String.valueOf(action.getCreatedDate()));
                likeDislikeModel.setLastUpdateDate(String.valueOf(action.getLastUpdateDate()));
                likeDislikeModel.setStatus(action.getStatus());
                likeDislikeModel.setUserId(action.getUserId());
                likeDislikeModels.add(likeDislikeModel);
            });
            model.setComments(commentModels);
            model.setLikeDislikes(likeDislikeModels);
            return model;
    }

    public ResponseEntity<ApiResponseModel> saveCommentDetails(CommentModel commentModel) {
        try{
            CommentEntity comment = new CommentEntity();
            PostEntity postEntity = postRepository.findByPostId(Long.valueOf(commentModel.getPostId()));
            comment.setPost(postEntity);
            comment.setComment(commentModel.getComment());
            comment.setUserId(commentModel.getUserId());
            comment.setStatus("Active");
            comment.setCreatedDate(new Date());
            comment.setUpdatedBy(commentModel.getUserId());
            comment.setCreatedBy(commentModel.getUserId());
            comment.setLastUpdateDate(new Date());
            commentRepository.save(comment);
            return new ResponseEntity<>(new ApiResponseModel("Success", "commented successfully."), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponseModel("Failed", "unsuccessful."), HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<ApiResponseModel> saveLikeDislikeActionDetails(LikeDislikeModel likeDislikeModel) {
        try{
            LikeDislikeEntity likeDislikeEntity = new LikeDislikeEntity();
            PostEntity postEntity = postRepository.findByPostId(Long.valueOf(likeDislikeModel.getPostId()));
            likeDislikeEntity.setActionType(likeDislikeModel.getActionType());
            likeDislikeEntity.setUserId(likeDislikeModel.getUserId());
            likeDislikeEntity.setPost(postEntity);
            likeDislikeEntity.setStatus("Active");
            likeDislikeEntity.setCreatedDate(new Date());
            likeDislikeEntity.setUpdatedBy(likeDislikeModel.getUserId());
            likeDislikeEntity.setCreatedBy(likeDislikeModel.getUserId());
            likeDislikeEntity.setLastUpdateDate(new Date());
            likeDislikeRepository.save(likeDislikeEntity);
            return new ResponseEntity<>(new ApiResponseModel("Success", "successful."), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponseModel("Failed", "unsuccessful."), HttpStatus.FORBIDDEN);
        }
    }
}
