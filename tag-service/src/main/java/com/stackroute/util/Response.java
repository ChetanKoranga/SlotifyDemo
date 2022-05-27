/*
author: chetan.koranga,
date of creation: 24/05/22
*/

package com.stackroute.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Response {
    private String status;
    private Object data;
    private String message;
}