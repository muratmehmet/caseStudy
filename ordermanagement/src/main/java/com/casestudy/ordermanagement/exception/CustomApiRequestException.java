package com.casestudy.ordermanagement.exception;

public class CustomApiRequestException extends RuntimeException{

    public CustomApiRequestException(String message){
        super(message);
    }

    public CustomApiRequestException(String message, Throwable cause){
        super(message, cause);
    }
}
