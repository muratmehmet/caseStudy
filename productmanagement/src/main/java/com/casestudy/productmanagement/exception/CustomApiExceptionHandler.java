package com.casestudy.productmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CustomApiExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleApiRequestException(CustomApiRequestException e){
        CutomeApiException apiException = new CutomeApiException(e.getMessage(),
                                        e, HttpStatus.BAD_REQUEST,
                                        ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

}
