/*
author: chetan.koranga,
date of creation: 07/06/22
*/

package com.stackroute.exceptions;

public class RabbitMQException extends RuntimeException{
    public RabbitMQException(String message) {
        super(message);
    }
}