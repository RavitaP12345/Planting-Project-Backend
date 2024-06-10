package com.project.planting_project_startup.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserModel extends SharedModel{
    private Long userId;
    @NotNull(message = "First name must not be null.")
    @NotBlank(message = "First name must not be blank.")
    @Pattern(regexp = "^[a-zA-Z0-9_]{5,20}$", message = "First name must be alphanumeric and between 5 to 20 characters.")
    private String userFirstName;
    @NotNull(message = "Last name must not be null.")
    @NotBlank(message = "Last name must not be blank.")
    @Pattern(regexp = "^[a-zA-Z0-9_]{5,20}$", message = "Last name must be alphanumeric and between 5 to 20 characters.")
    private String userLastName;
    private String userMiddleName;
    @NotNull(message = "Gender name must not be null.")
    @NotBlank(message = "Gender name must not be blank.")
    private String gender;
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits.")
    private String mobileNumber;
    @Email(message = "Email id is incorrect.")
    @NotNull(message = "Email id must not be null.")
    @NotBlank(message = "Email id must be blank.")
    private String emailId;
    @NotNull(message = "Address must not be null.")
    @NotBlank(message = "Address must not be blank.")
    private String address;
    @NotNull(message = "City must not be null.")
    @NotBlank(message = "City must not be blank.")
    private String city;
    @NotNull(message = "State must not be null.")
    @NotBlank(message = "State must not be blank.")
    private String state;
    @NotNull(message = "Country must not be null.")
    @NotBlank(message = "Country must not be blank.")
    private String country;
    @NotNull(message = "Postal code must not be null.")
    @NotBlank(message = "Postal code must not be blank.")
    private String postalCode;
    @NotNull(message = "Password must not be null.")
    @NotBlank(message = "Password must not be blank.")
    private String password;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserMiddleName() {
        return userMiddleName;
    }

    public void setUserMiddleName(String userMiddleName) {
        this.userMiddleName = userMiddleName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
