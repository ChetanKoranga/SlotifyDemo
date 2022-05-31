package com.stackroute.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterviewerDto {
    private String userName;
    private String password;
    private String userRole;
    private String email;
}
