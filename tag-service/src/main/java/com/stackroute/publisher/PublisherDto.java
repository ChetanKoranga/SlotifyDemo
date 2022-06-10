package com.stackroute.publisher;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
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