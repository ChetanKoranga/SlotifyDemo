/*
author: chetan.koranga,
date of creation: 18/05/22
*/

package com.stackroute.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "Slots")
public class SlotUpdate {
    @Id
    private String slotId;
    private SlotStatus slotStatus;
    private String meetingVenue;
    private String meetingLink;
}