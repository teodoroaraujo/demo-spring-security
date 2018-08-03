package com.example.demo.service;

import com.example.demo.DTO.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface CustomUserDetailsService extends UserDetailsService {

    public void registerUser(UserDTO user);

}
