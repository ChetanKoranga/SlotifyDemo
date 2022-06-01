package com.stackroute.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value
            = NoSuchDataExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody ErrorResponse
    handleException(NoSuchDataExistsException ex)
    {
        return new ErrorResponse(
                HttpStatus.CONFLICT.value(), ex.getMessage());
    }
    @ExceptionHandler(value
            = DataAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody ErrorResponse
    handleException(DataAlreadyExistsException ex)
    {
        return new ErrorResponse(
                HttpStatus.CONFLICT.value(), ex.getMessage());
    }
}
