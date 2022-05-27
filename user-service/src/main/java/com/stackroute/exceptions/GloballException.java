package com.stackroute.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GloballException {

    @ExceptionHandler(AlreadyExitException.class)
    public ResponseEntity<Object> exception(AlreadyExitException ex){
        return new ResponseEntity<>("Profile Already Exists", HttpStatus.FOUND);

    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> exception(ResourceNotFoundException ex){
        return new ResponseEntity<>("Interview Id Not Exist", HttpStatus.FOUND);

    }
}
