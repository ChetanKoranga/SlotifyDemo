/*
author: chetan.koranga,
date of creation: 23/05/22
*/

package com.stackroute.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,reason = "Slot Already Booked")
public class SlotAlreadyBookedException extends RuntimeException{
    public SlotAlreadyBookedException(String message) {
        super(message);
    }
}