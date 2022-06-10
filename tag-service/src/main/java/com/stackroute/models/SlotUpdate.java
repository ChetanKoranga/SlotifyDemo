/*
author: chetan.koranga,
date of creation: 18/05/22
*/

package com.stackroute.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
@Document(collection = "Slots")
public class SlotUpdate {
    @Id
    private String slotId;
    private SlotStatus slotStatus;
    private String meetingVenue;
    private String meetingLink;
}