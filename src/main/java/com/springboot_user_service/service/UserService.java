package com.springboot_user_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot_user_service.dto.UserDto;
import com.springboot_user_service.entity.User;
import com.springboot_user_service.exception.InvalidInputException;
import com.springboot_user_service.response.ApiResponse;

@Service
public class UserService {

    List<User> list = new ArrayList<User>();

    public ApiResponse createUser(UserDto userDto){

        if(userDto==null || userDto.getName()==null || userDto.getName().isBlank())
            //return new ApiResponse("Invalid name", "FAILURE");
        throw new InvalidInputException("Invalid name", userDto);
        if(userDto==null ||userDto.getAge()<1)
            //return new ApiResponse("Invalid age", "FAILURE");
        throw new InvalidInputException("Invalid age", userDto);
        if(userDto==null ||userDto.getId()<1)
            //return new ApiResponse("Invalid id", "FAILURE");
        throw new InvalidInputException("Invalid id", userDto);


        User user = new User();
        user.setAge(userDto.getAge());
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        list.add(user);

        return new ApiResponse("User is created ", "SUCCESS", user);
    }

    public ApiResponse getAllUser(){
        if(list.isEmpty())
            return new ApiResponse("No available users", "SUCCESS");
        return new ApiResponse("Available users are ", "SUCCESS", list);

        
    }

}
