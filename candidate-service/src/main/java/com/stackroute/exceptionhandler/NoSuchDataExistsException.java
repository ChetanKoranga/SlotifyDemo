package com.stackroute.exceptionhandler;

public class NoSuchDataExistsException
        extends RuntimeException {

    private String message;

    public NoSuchDataExistsException() {}

    public NoSuchDataExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}