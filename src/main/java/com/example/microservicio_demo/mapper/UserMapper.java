package com.example.microservicio_demo.mapper;

import com.example.microservicio_demo.dtos.UserRequest;
import com.example.microservicio_demo.dtos.UserResponse;
import com.example.microservicio_demo.model.Users;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface UserMapper {
    List<UserResponse> entityToResponses(List<Users> Users);

    Users requestToEntity(UserRequest request);

    UserResponse entityToResponse(Users users);

}
