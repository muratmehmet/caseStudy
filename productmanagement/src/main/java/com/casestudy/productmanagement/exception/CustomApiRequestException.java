package com.casestudy.productmanagement.exception;

public class CustomApiRequestException extends RuntimeException{

    public CustomApiRequestException(String message){
        super(message);
    }

    public CustomApiRequestException(String message, Throwable cause){
        super(message, cause);
    }
}
