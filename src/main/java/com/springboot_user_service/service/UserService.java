package com.springboot_user_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot_user_service.dto.UserDto;
import com.springboot_user_service.entity.User;

@Service
public class UserService {

    List<User> list = new ArrayList<User>();

    public String createUser(UserDto userDto){

        if(userDto==null || userDto.getName()==null || userDto.getName().isBlank())
            return "Invalid name";
        if(userDto==null ||userDto.getAge()<1)
            return "Invalid age";
        if(userDto==null ||userDto.getId()<1)
            return "Invalid id";


        User user = new User();
        user.setAge(userDto.getAge());
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        list.add(user);

        return "User is created "+user;
    }

    public String getAllUser(){
        if(list.isEmpty())
            return "No available users";
        return "Available users are "+list;

        
    }

}
