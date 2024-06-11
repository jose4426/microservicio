package com.example.microservicio_demo.mapper;

import com.example.microservicio_demo.dtos.UserRequest;
import com.example.microservicio_demo.dtos.UserResponse;
import com.example.microservicio_demo.model.Users;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-11T09:56:27-0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public List<UserResponse> entityToResponses(List<Users> Users) {
        if ( Users == null ) {
            return null;
        }

        List<UserResponse> list = new ArrayList<UserResponse>( Users.size() );
        for ( Users users : Users ) {
            list.add( entityToResponse( users ) );
        }

        return list;
    }

    @Override
    public Users requestToEntity(UserRequest request) {
        if ( request == null ) {
            return null;
        }

        Users.UsersBuilder users = Users.builder();

        users.id( request.getId() );
        users.username( request.getUsername() );
        users.email( request.getEmail() );

        return users.build();
    }

    @Override
    public UserResponse entityToResponse(Users users) {
        if ( users == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.id( users.getId() );
        userResponse.username( users.getUsername() );
        userResponse.email( users.getEmail() );

        return userResponse.build();
    }
}
