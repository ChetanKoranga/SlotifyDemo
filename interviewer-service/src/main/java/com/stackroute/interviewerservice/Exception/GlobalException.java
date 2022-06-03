package com.stackroute.interviewerservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(interviewIdNotExists.class)
    public ResponseEntity<Object> exception(interviewIdNotExists ex){
        return new ResponseEntity<>("Profile Already Exists", HttpStatus.FOUND);
    }
    @ExceptionHandler(profileAlreadyExists.class)
    public ResponseEntity<Object> exception(profileAlreadyExists ex){
        return new ResponseEntity<>("Interview Id Not Exists", HttpStatus.FOUND);
    }
    @ExceptionHandler(RecordNotFound.class)
    public ResponseEntity<Object> exception(RecordNotFound ex){
        return new ResponseEntity<>("Record Not Found With Id", HttpStatus.FOUND);
    }

}
