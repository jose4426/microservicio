package com.example.microservicio_demo.service;


import com.example.microservicio_demo.dtos.UserRequest;
import com.example.microservicio_demo.dtos.UserResponse;
import com.example.microservicio_demo.mapper.UserMapper;
import com.example.microservicio_demo.model.Users;
import com.example.microservicio_demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserServImpl implements UserServ {
    private UserRepository repository;
    private UserMapper mapper;

    @Override
    public List<UserResponse> findAll() {
        List<Users> users = repository.findAll();
        return users.stream().map(mapper::entityToResponse).collect(Collectors.toList());

    }

    @Override
    public UserResponse save(UserRequest request) {
        Users users = mapper.requestToEntity(request);
       users =  repository.save(users);

       return mapper.entityToResponse(users);

    }
}
