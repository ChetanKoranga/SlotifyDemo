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
    private String subject;
    private String interviername;
    private String intervierEmailId;
    private String tagmembername;
    private String tagEmailId;
    private String candidatename;
    private String candidateEmailId;
    private String messageText;
    @JsonFormat(pattern = "HH:mm")
    private Date startTime;
    @JsonFormat(pattern = "HH:mm")
    private Date endTime;
    @JsonFormat(pattern = "yyyy:MM:dd")
    private Date date;
}
