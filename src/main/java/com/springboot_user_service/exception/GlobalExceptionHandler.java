package com.springboot_user_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot_user_service.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ApiResponse> handleInvalidInputException(InvalidInputException iie){
        //return new ApiResponse(iie.getMessage(), "FAILURE", iie.getData());
        //OR below code.
        //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(iie.getMessage(), "FAILURE", iie.getData()));
        //Even if i donot write above line and just have ApiResponse type then also user gets correct message just without the status code.
        ApiResponse response = new ApiResponse(iie.getMessage(), "FAILURE",iie.getData());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
