package com.springboot_user_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot_user_service.dto.UserDto;

@RestController
public class UserController {

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
        return "The requested user is "+ userDto.getName();
    }

}
