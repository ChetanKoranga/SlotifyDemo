/*
author: chetan.koranga,
date of creation: 30/05/22
*/

package com.stackroute.consumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ConsumerDto {
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