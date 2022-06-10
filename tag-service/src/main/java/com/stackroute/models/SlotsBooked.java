/*
author: chetan.koranga,
date of creation: 18/05/22
*/

package com.stackroute.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document(collection = "Slots")
public class SlotsBooked {
    @Id
    private String slotId = UUID.randomUUID().toString();
    private String interviewerEmailId;
    private String interviewerName;
    private String tagEmailId;
    private String tagMemberName;
    private String tagTeamName;
    private String candidateId;
    private String candidateName;
    private String candidateEmailId;
    @CreatedDate
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date bookedDate = new Date();
    private SlotStatus slotStatus;
//    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date startTime;
//    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date endTime;
    private Resume resume;
    private String notes;
    private String meetingVenue;
    private String meetingLink;


}