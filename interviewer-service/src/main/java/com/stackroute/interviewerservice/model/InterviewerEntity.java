package com.stackroute.interviewerservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "Interview")
public class InterviewerEntity{
    @Id
    private String slot_id = UUID.randomUUID().toString();
    private String interviewer_emailId;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date slot_date;
    @JsonFormat(pattern="HH:mm:ss")
    private String start_time;
    @JsonFormat(pattern="HH:mm:ss")
    private String end_time;
    private String meeting_venue;
    private String meeting_link;
    private SlotStatus slot_status;
}
