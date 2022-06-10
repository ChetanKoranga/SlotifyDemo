package com.stackroute.publisher;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stackroute.models.Resume;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

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