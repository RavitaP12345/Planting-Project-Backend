package com.project.planting_project_startup.resources;

import com.project.planting_project_startup.models.ApiResponseModel;
import com.project.planting_project_startup.models.UserModel;
import com.project.planting_project_startup.services.UserService;
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
@RequestMapping("/user")
public class UserResource {
    @Autowired
    private UserService userService;

    @PostMapping("/saveUserDetails")
    public ResponseEntity<ApiResponseModel> saveUserDetails(@Valid @RequestBody UserModel userModel, BindingResult result){
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        if(result.hasErrors()){
            for(FieldError error : result.getFieldErrors()){
                linkedHashSet.add(error.getDefaultMessage());
            }
            return new ResponseEntity<>(new ApiResponseModel("failed", "Something went wrong", linkedHashSet), HttpStatus.FORBIDDEN);
        }else {
            return userService.saveUserDetails(userModel);
        }
    }

    @PostMapping("/updateUserDetails")
    public ResponseEntity<ApiResponseModel> updateUserDetails(@RequestBody UserModel userModel){
        return userService.updateUserDetails(userModel);
    }
    @DeleteMapping("/deleteUserDetailsByUserId/{userId}")
    public ResponseEntity<ApiResponseModel> deleteUserDetailsByUserId(@PathVariable String userId){
        return userService.deleteUserDetailsByUserId(userId);
    }

    @GetMapping("/getUserDetailsByUserId/{userId}")
    public UserModel getUserDetailsByUserId(@PathVariable String userId){
        return userService.getUserDetailsByUserId(userId);
    }
    @GetMapping("/getAllActiveUsers")
    public List<UserModel> getAllActiveUsers(){
        return userService.getAllActiveUsers();
    }

    @PostMapping("/changeUserRoleByUserId/{userId}/{role}")
    public ResponseEntity<ApiResponseModel> changeUserRoleByUserId(@PathVariable String userId, @PathVariable String role){
        return userService.changeUserRoleByUserId(userId, role);
    }

}
