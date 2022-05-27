/*
author: chetan.koranga,
date of creation: 24/05/22
*/

package com.stackroute.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InternalServerException extends RuntimeException{
    public InternalServerException(String message) {
        super(message);
    }
}