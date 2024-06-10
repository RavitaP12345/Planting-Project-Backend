package com.project.planting_project_startup.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_login_details")
public class UserLogin extends SharedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userLoginId;
    private String mobileNumber;
    private String emailId;
    private String password;
    private String role;
    @OneToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity user;

    public Long getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(Long userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
