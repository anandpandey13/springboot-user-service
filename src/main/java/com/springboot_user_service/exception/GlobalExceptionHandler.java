package com.springboot_user_service.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot_user_service.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidInputException.class)
    public ApiResponse handleInvalidInputException(InvalidInputException iie){
        return new ApiResponse(iie.getMessage(), "FAILURE", iie.getData());
    }

}
