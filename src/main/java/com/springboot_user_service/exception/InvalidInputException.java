package com.springboot_user_service.exception;

public class InvalidInputException extends RuntimeException{

    private Object data;
    public InvalidInputException(String message, Object data) {
        super(message);
        this.data=data;
    }
    public Object getData() {
        return data;
    }

}
