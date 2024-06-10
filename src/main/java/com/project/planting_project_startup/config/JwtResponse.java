package com.project.planting_project_startup.config;


public class JwtResponse {
    private String jwtToken;
    private String username;

    // Default constructor
    public JwtResponse() {}

    // Parameterized constructor
    public JwtResponse(String jwtToken, String username) {
        this.jwtToken = jwtToken;
        this.username = username;
    }

    // Getter for jwtToken
    public String getJwtToken() {
        return jwtToken;
    }

    // Setter for jwtToken
    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Builder class
    public static class Builder {
        private String jwtToken;
        private String username;

        public Builder() {}

        public Builder jwtToken(String jwtToken) {
            this.jwtToken = jwtToken;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public JwtResponse build() {
            return new JwtResponse(jwtToken, username);
        }
    }

    // Static method to get builder instance
    public static Builder builder() {
        return new Builder();
    }

}
