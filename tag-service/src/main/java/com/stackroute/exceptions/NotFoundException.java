/*
author: chetan.koranga,
date of creation: 23/05/22
*/

package com.stackroute.exceptions;


public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}