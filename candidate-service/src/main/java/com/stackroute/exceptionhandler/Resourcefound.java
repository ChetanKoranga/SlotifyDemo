package com.stackroute.exceptionhandler;

public class Resourcefound extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public Resourcefound(String message) {
        super(message);
    }

    public Resourcefound(String message, Throwable throwable) {
        super(message, throwable);
    }
}
