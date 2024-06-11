package com.example.microservicio_demo.service;

import com.example.microservicio_demo.dtos.UserRequest;
import com.example.microservicio_demo.dtos.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface UserServ {
    List<UserResponse> findAll();
    UserResponse save(UserRequest request);

}
