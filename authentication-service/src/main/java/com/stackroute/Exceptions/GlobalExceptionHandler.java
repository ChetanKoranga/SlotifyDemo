package com.stackroute.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

		@ExceptionHandler(UserNotFoundException.class)
		public ResponseEntity<ErrorInfo> UserNotFoundException (UserNotFoundException unfe) {
			ErrorInfo errorInfo = new ErrorInfo("UserNotFound",unfe.getMessage(),HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<>(errorInfo,HttpStatus.NOT_FOUND);
		}
	
}
 