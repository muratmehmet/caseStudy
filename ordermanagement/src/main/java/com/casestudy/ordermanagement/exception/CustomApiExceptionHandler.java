package com.casestudy.ordermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CustomApiExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleApiRequestException(CustomApiRequestException e){
        CustomApiException apiException = new CustomApiException(e.getMessage(),
                                        e, HttpStatus.BAD_REQUEST,
                                        ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

}
