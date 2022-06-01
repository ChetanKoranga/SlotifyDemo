/*
author: chetan.koranga,
date of creation: 30/05/22
*/

package com.stackroute.consumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ConsumerDTO {
    private String userName;
    private String password;
    private String userRole;
    private String email;
}