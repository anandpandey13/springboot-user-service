package com.springboot_user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot_user_service.dto.UserDto;
import com.springboot_user_service.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String defaultDisplay(){
        return "This is Default Display page";
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello buddy, this is user micro service";
    }

    @PostMapping("/user")
    public String createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @GetMapping("/users")
    public String getAllUser(){
        return userService.getAllUser();
    }

}
