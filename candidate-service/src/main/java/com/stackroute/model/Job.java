package com.stackroute.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Document
public class Job {

    @Id
     private String job_posting_id=UUID.randomUUID().toString();

    @Indexed(unique = true)
    private String jobTitle;
    private String job_description;
    private String eligibility;
    private String tech_stack;
    private String job_posting_date;
    private String job_end_date;

    private String tagMemberEmailId;
    private String tag_member_name;
    private String tag_team_name;
    private String job_post_status;
    private String job_location;
    private String job_type;
    private String CTC_Range;



}
