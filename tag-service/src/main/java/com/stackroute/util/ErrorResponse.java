/*
author: chetan.koranga,
date of creation: 25/05/22
*/

package com.stackroute.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorResponse {
    private String status;
    private  String error;
    private String message;
}