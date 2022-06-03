/*
author: chetan.koranga,
date of creation: 30/05/22
*/

package com.stackroute.consumer;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String subject;
    private String interviername;
    private String intervierEmailId;
    private String tagmembername;
    private String tagEmailId;
    private String candidatename;
    private String candidateEmailId;
    private String messageText;
    private Date startTime;
    private Date endTime;
    private Date date;
}