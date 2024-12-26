package com.napier.mlsServices.dto;

public class JwtAuthResponseTokenNRole {
    private String token;
    private String role; 

    public JwtAuthResponseTokenNRole() {
        super();
    }

    public JwtAuthResponseTokenNRole(String token, String role) { // Updated constructor
        super();
        this.token = token;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "JwtAuthResponseTokenNRole [token=" + token + ", role=" + role + "]";
    }
}
