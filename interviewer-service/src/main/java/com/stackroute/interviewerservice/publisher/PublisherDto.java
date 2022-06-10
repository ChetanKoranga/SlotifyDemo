package com.stackroute.interviewerservice.publisher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PublisherDto {
    String subject;
    String interviername;
    String intervierEmailId;
    String tagmembername;
    String tagEmailId;
    String candidatename;
    String candidateEmailId;
    String messageText;
    private Date startTime;
    private Date endTime;
    private Date date;
}