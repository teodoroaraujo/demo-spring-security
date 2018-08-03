package com.example.demo.controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.service.CustomUserDetailsService;
import com.example.demo.service.UserDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;

@RestController()
@RequestMapping("demo-user")
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
    public ResponseEntity<String> checkUser(@PathVariable String email ) {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);
        return ResponseEntity.ok()
                .body(userDetails.getUsername());
    }


}
