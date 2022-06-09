package com.stackroute.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor

@AllArgsConstructor
@Document

public class JobApplication {
    @Id
    private String applicationId=UUID.randomUUID().toString();
    private String job_posting_id;
    private String jobTitle;
    private String candidate_name;
    private String candidate_emailId;
    @JsonFormat(pattern="yyyy-MM-dd")
    private String date_of_application;
    private String candidate_experience;
    private String tagMemberEmailId;
    private String expected_CTC;
    private Boolean shortlisted;
    private Exam_Status status;
    private Group_Discussion  Gd;
    private Interview interview;


}
