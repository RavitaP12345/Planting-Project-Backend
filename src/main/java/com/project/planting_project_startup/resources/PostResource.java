package com.project.planting_project_startup.resources;

import com.project.planting_project_startup.models.ApiResponseModel;
import com.project.planting_project_startup.models.CommentModel;
import com.project.planting_project_startup.models.LikeDislikeModel;
import com.project.planting_project_startup.models.PostModel;
import com.project.planting_project_startup.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostResource {
    @Autowired
    PostService postService;

    @PostMapping("/savePostDetails")
    public ResponseEntity<ApiResponseModel> savePostDetails(@Valid @RequestBody PostModel postModel, BindingResult result){
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        if(result.hasErrors()){
            for(FieldError error : result.getFieldErrors()){
                linkedHashSet.add(error.getDefaultMessage());
            }
            return new ResponseEntity<>(new ApiResponseModel("Failed", "Something went wrong.", linkedHashSet), HttpStatus.FORBIDDEN);
        }else {
            return postService.savePostDetails(postModel);
        }
    }
    @GetMapping("/getAllActivePosts")
    public List<PostModel> getAllActivePosts(){
        return postService.getAllActivePosts();
    }

    @GetMapping("/getAllActivePostsByUserId/{userId}")
    public List<PostModel> getAllActivePostsByUserId(@PathVariable String userId){
        return postService.getAllActivePostsByUserId(userId);
    }
    @GetMapping("/getPostDetailsByPostId/{postId}")
    public PostModel getPostDetailsByPostId(@PathVariable String postId){
        return  postService.getPostDetailsByPostId(postId);
    }
    @DeleteMapping("/deletePostDetailsByPostId/{postId}")
    public ResponseEntity<ApiResponseModel> deletePostDetailsByPostId(@PathVariable String postId){
        return postService.deletePostDetailsByPostId(postId);
    }
    @PostMapping("/saveCommentDetails")
    public ResponseEntity<ApiResponseModel> saveCommentDetails(@Valid @RequestBody CommentModel commentModel, BindingResult result){
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        if(result.hasErrors()){
            for(FieldError error : result.getFieldErrors()){
                linkedHashSet.add(error.getDefaultMessage());
            }
            return new ResponseEntity<>(new ApiResponseModel("Failed", "Something went wrong.", linkedHashSet), HttpStatus.FORBIDDEN);
        }else {
            return postService.saveCommentDetails(commentModel);
        }
    }
    @PostMapping("/saveLikeDislikeActionDetails")
    public ResponseEntity<ApiResponseModel> saveLikeDislikeActionDetails(@Valid @RequestBody LikeDislikeModel likeDislikeModel, BindingResult result){
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        if(result.hasErrors()){
            for(FieldError error : result.getFieldErrors()){
                linkedHashSet.add(error.getDefaultMessage());
            }
            return new ResponseEntity<>(new ApiResponseModel("Failed", "Something went wrong.", linkedHashSet), HttpStatus.FORBIDDEN);
        }else {
            return postService.saveLikeDislikeActionDetails(likeDislikeModel);
        }
    }

}
