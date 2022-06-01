/*
author: chetan.koranga,
date of creation: 31/05/22
*/

package com.stackroute.interviewerservice.publisher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class ProducerDto {
    private String userName;
    private String password;
    private String userRole;
    private String email;
}