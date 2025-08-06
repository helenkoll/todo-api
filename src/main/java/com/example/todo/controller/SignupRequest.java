package com.example.todo.controller;

import java.util.Set;

import com.example.todo.model.Role;

public class SignupRequest {
    private String username;
    private String password;
    private Set <Role> role;
    public SignupRequest() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set <Role> getRole() {
        return role;
    }

    public void setRoleS(Set<Role> role) {
        this.role = role;
    }
}