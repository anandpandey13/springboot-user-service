package com.springboot_user_service.dto;

public class UserDto {
    private Integer id;
    private String name;
    private Integer age;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    
}

/*
Why DTO commonly uses Integer - DTOs usually use wrapper classes (Integer, Long, Double) because:
They can hold null
Useful for validation
Useful when request fields are optional
Helps detect missing JSON fields
 */