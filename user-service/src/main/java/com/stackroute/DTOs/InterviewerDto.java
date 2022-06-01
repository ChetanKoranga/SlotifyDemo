package com.stackroute.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterviewerDto {
    private String firstName;
    private String  lastName;
    private Long mobileNumber;
    private String emailId;
    private String techTrack;
    private String password;

}
