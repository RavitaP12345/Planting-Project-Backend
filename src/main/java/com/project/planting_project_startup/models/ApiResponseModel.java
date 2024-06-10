package com.project.planting_project_startup.models;


import java.util.LinkedHashSet;

public class ApiResponseModel {
    private String status;
    private String message;
    LinkedHashSet<String> linkedHashSet;

    public ApiResponseModel(String status, String message, LinkedHashSet<String> linkedHashSet) {
        this.status = status;
        this.message = message;
        this.linkedHashSet = linkedHashSet;
    }

    public ApiResponseModel(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LinkedHashSet<String> getLinkedHashSet() {
        return linkedHashSet;
    }

    public void setLinkedHashSet(LinkedHashSet<String> linkedHashSet) {
        this.linkedHashSet = linkedHashSet;
    }

}
