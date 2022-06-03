package com.stackroute.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Email {

    String subject;
    String statusCode;
    String interviewername;
    String interviewerEmailId;
    String tagEmailId;
    String candidateEmailId;
    String messageText;
    @JsonFormat(pattern = "HH:mm")
    private Date startTime;
    @JsonFormat(pattern = "HH:mm")
    private Date endTime;
    @JsonFormat(pattern = "yyyy:MM:dd")
    private Date date;
}
