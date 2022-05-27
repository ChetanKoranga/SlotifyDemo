package com.stackroute.exceptionhandler;

import javax.xml.crypto.Data;

public class DataAlreadyExistsException
      extends RuntimeException {

        private String message;

    public DataAlreadyExistsException() {}

    public DataAlreadyExistsException(String msg)
        {
            super(msg);
            this.message = msg;
        }
    }

