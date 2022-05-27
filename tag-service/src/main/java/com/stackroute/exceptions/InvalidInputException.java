/*
author: chetan.koranga,
date of creation: 23/05/22
*/

package com.stackroute.exceptions;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}