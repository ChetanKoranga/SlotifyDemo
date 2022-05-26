package com.stackroute.DTOs;

import com.stackroute.Models.Resume;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateDto {

    private String emailId;
    private String firstName;
    private String  lastName;
    private long mobileNumber;
    private float yearsOfOxperience;
    private float currentCtc;
    private float expectedCtc;
    private int noticePeriod;
    private String password;
    private Resume resume;

    }
