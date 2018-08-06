package com.example.demo.controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;

@RestController("demo-user")
public class UserDemoController {

    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    public UserDemoController(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @PostMapping
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDTO user) {
        customUserDetailsService.registerUser(user);
        return ResponseEntity.created(null)
                .body(Collections.singletonMap("message", "User created successfully"));
    }

    @GetMapping
    public ResponseEntity isSignedIn() {
        return ResponseEntity.ok().build();
    }
}
