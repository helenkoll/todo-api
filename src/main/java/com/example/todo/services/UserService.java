package com.example.todo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    private SignupRequest register(SignupRequest req) {
        if (userRepo.existsByUsername(req.getUsername())) {
            throw new RuntimeException("Username already taken");
        } 
        return req;
}

    private static class SignupRequest {

        public SignupRequest() {
        }

        private String getUsername() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}

