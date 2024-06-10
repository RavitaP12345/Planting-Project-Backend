package com.project.planting_project_startup.services;

import com.project.planting_project_startup.entities.UserEntity;
import com.project.planting_project_startup.entities.UserLogin;
import com.project.planting_project_startup.models.ApiResponseModel;
import com.project.planting_project_startup.models.UserModel;
import com.project.planting_project_startup.repositories.UserLoginRepository;
import com.project.planting_project_startup.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserLoginRepository userLoginRepository;
    @Autowired
    JavaMailSender javaMailSender;

    @Transactional
    public ResponseEntity<ApiResponseModel> saveUserDetails(UserModel userModel) {
        /*try{*/
            UserEntity user = new UserEntity();
            user.setUserFirstName(userModel.getUserFirstName());
            user.setUserMiddleName(userModel.getUserMiddleName());
            user.setUserLastName(userModel.getUserLastName());
            user.setAddress(userModel.getAddress());
            user.setCity(userModel.getCity());
            user.setCountry(userModel.getCountry());
            user.setGender(userModel.getGender());
            user.setUserType("User");
            user.setMobileNumber(userModel.getMobileNumber());
            user.setEmailId(userModel.getEmailId());
            user.setState(userModel.getState());
            user.setPostalCode(userModel.getPostalCode());
            user.setCreatedBy(String.valueOf(user.getUserId()));
            user.setUpdatedBy(String.valueOf(user.getUserId()));
            user.setCreatedDate(new Date());
            user.setLastUpdateDate(new Date());
            user.setStatus("Active");
            userRepository.save(user);
            UserLogin userLogin = new UserLogin();
            userLogin.setEmailId(userModel.getEmailId());
            userLogin.setMobileNumber(userModel.getMobileNumber());
            userLogin.setPassword(userModel.getPassword());
            userLogin.setRole("User");
            userLogin.setUser(user);
            userLogin.setCreatedBy(String.valueOf(user.getUserId()));
            userLogin.setUpdatedBy(String.valueOf(user.getUserId()));
            userLogin.setCreatedDate(new Date());
            userLogin.setLastUpdateDate(new Date());
            userLogin.setStatus("Active");
            userLoginRepository.save(userLogin);
        user.setCreatedBy(String.valueOf(user.getUserId()));
        user.setUpdatedBy(String.valueOf(user.getUserId()));
        userRepository.save(user);

            String text = "You have successfully registered. Your email id is: "+user.getEmailId()+" mobile number is: "+user.getMobileNumber()+" and password is: "+userLogin.getPassword()+" .";
            String message = sendMail(user.getEmailId(), text, "Registered successfully.");
            System.out.println("message-==>"+message);
            return new ResponseEntity<>(new ApiResponseModel("Success", "Saved successfully."), HttpStatus.OK);
        /*}catch (Exception e){
            return new ResponseEntity<>(new ApiResponseModel("Failed", "Not saved."), HttpStatus.FORBIDDEN);

        }*/

    }
    @Transactional
    public ResponseEntity<ApiResponseModel> updateUserDetails(UserModel userModel) {
        try{
            if(userModel.getUserId()!=null || userModel.getUserId()!=0){
                UserEntity user = userRepository.findByUserId(userModel.getUserId());
                user.setUserFirstName(userModel.getUserFirstName());
                user.setUserMiddleName(userModel.getUserMiddleName());
                user.setUserLastName(userModel.getUserLastName());
                user.setAddress(userModel.getAddress());
                user.setCity(userModel.getCity());
                user.setCountry(userModel.getCountry());
                user.setGender(userModel.getGender());
                user.setMobileNumber(userModel.getMobileNumber());
                user.setEmailId(userModel.getEmailId());
                user.setState(userModel.getState());
                user.setPostalCode(userModel.getPostalCode());
                user.setUpdatedBy(String.valueOf(user.getUserId()));
                user.setLastUpdateDate(new Date());
                UserLogin userLogin = userLoginRepository.findByUser(user);
                userLogin.setEmailId(userModel.getEmailId());
                userLogin.setMobileNumber(userModel.getMobileNumber());
                userRepository.save(user);
                String text = "You have successfully updated your details. Your updated details like email id is: "+user.getEmailId()+" mobile number is: "+user.getMobileNumber()+" and password is: "+userLogin.getPassword()+" .";
                String message = sendMail(user.getEmailId(), text, "Updated successfully.");
                System.out.println("message-==>"+message);
                return new ResponseEntity<>(new ApiResponseModel("Success", "Updated successfully."), HttpStatus.OK);

            }else {
                return new ResponseEntity<>(new ApiResponseModel("Failed", "User id is incorrect."), HttpStatus.FORBIDDEN);

            }
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponseModel("Failed", "Something went wrong."), HttpStatus.FORBIDDEN);
        }

    }

    public String sendMail(String receiverEmailId, String text, String subject){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(receiverEmailId);
        message.setSubject(subject);
        message.setText(text);
        try{
            javaMailSender.send(message);
            return "success";
        }catch (Exception e){
            return "failed";
        }

    }
    @Transactional
    public ResponseEntity<ApiResponseModel> deleteUserDetailsByUserId(String userId) {
        try{
            UserEntity user = userRepository.findByUserId(Long.valueOf(userId));
            user.setStatus("Inactive");
            userRepository.save(user);
            UserLogin userLogin = userLoginRepository.findByUser(user);
            userLogin.setStatus("Inactive");
            userLoginRepository.save(userLogin);
            return new ResponseEntity<>(new ApiResponseModel("Success", "Deleted successfully."), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponseModel("Failed", "Not deleted"), HttpStatus.FORBIDDEN);

        }
    }

    public UserModel getUserDetailsByUserId(String userId) {
        UserEntity user = userRepository.findByUserId(Long.valueOf(userId));
        UserModel userModel = new UserModel();
        userModel.setUserFirstName(user.getUserFirstName());
        userModel.setUserMiddleName(user.getUserMiddleName());
        userModel.setUserLastName(user.getUserLastName());
        userModel.setAddress(user.getAddress());
        userModel.setCity(user.getCity());
        userModel.setCountry(user.getCountry());
        userModel.setGender(user.getGender());
        userModel.setMobileNumber(user.getMobileNumber());
        userModel.setEmailId(user.getEmailId());
        userModel.setState(user.getState());
        userModel.setPostalCode(user.getPostalCode());
        userModel.setCreatedBy(String.valueOf(user.getUserId()));
        userModel.setUpdatedBy(String.valueOf(user.getUserId()));
        userModel.setCreatedDate(String.valueOf(user.getCreatedDate()));
        userModel.setLastUpdateDate(String.valueOf(user.getLastUpdateDate()));
        userModel.setStatus(user.getStatus());
        userModel.setUserId(user.getUserId());
        userModel.setStatus(user.getStatus());
        return userModel;
    }

    public List<UserModel> getAllActiveUsers() {
        List<UserModel> userModelList = new ArrayList<>();
        List<UserEntity> userEntities = userRepository.findAll().stream().filter(status -> status.getStatus().equalsIgnoreCase("Active")).toList();
        System.out.println("userEntities.size()===>"+userEntities.size());
        userEntities.forEach(user->{
            UserModel userModel = new UserModel();
            userModel.setUserFirstName(user.getUserFirstName());
            userModel.setUserMiddleName(user.getUserMiddleName());
            userModel.setUserLastName(user.getUserLastName());
            userModel.setAddress(user.getAddress());
            userModel.setCity(user.getCity());
            userModel.setCountry(user.getCountry());
            userModel.setGender(user.getGender());
            userModel.setMobileNumber(user.getMobileNumber());
            userModel.setEmailId(user.getEmailId());
            userModel.setState(user.getState());
            userModel.setPostalCode(user.getPostalCode());
            userModel.setCreatedBy(String.valueOf(user.getUserId()));
            userModel.setUpdatedBy(String.valueOf(user.getUserId()));
            userModel.setCreatedDate(String.valueOf(user.getCreatedDate()));
            userModel.setLastUpdateDate(String.valueOf(user.getLastUpdateDate()));
            userModel.setStatus(user.getStatus());
            userModelList.add(userModel);
        });
        return userModelList;
    }
    @Transactional
    public ResponseEntity<ApiResponseModel> changeUserRoleByUserId(String userId, String role) {
        try{
            UserEntity userEntity = userRepository.findByUserId(Long.valueOf(userId));
            userEntity.setUserType(role);
            userEntity.setLastUpdateDate(new Date());
            userRepository.save(userEntity);
            UserLogin userLogin = userLoginRepository.findByUser(userEntity);
            userLogin.setLastUpdateDate(new Date());
            userLogin.setRole(role);
            userLoginRepository.save(userLogin);
            return new ResponseEntity<>(new ApiResponseModel("Success", "Updated Successfully."), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponseModel("Failed", "Not updated."), HttpStatus.FORBIDDEN);
        }
    }
}
