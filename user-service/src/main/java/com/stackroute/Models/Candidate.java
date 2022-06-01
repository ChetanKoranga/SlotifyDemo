package com.stackroute.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "candidate_data")
public class Candidate {

    @Id
    private String emailId;
    private String firstName;
    private String  lastName;
    private long mobileNumber;
    private float yearsOfExperience;
    private float currentCtc;
    private float expectedCtc;
    private int noticePeriod;
    private Resume resume;


    }
