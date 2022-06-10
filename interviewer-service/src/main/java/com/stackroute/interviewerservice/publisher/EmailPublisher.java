/*
author: chetan.koranga,
date of creation: 31/05/22
*/

package com.stackroute.interviewerservice.publisher;

import com.stackroute.interviewerservice.Config.MessagingConfig;
import com.stackroute.interviewerservice.model.InterviewerEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;


@Component
public class EmailPublisher {

    @Autowired
    RabbitTemplate template;

    public boolean sendBookedSlotDetails(InterviewerEntity interviewerEntity) throws Exception {
        PublisherDto publisherDto = new PublisherDto();
        try {
            System.out.println("Sent to queue:  " + interviewerEntity);
            publisherDto.setSubject("Slot Updated");
//            publisherDto.setInterviername(interviewerEntity.getInterviewerName());
            publisherDto.setIntervierEmailId(interviewerEntity.getInterviewer_emailId());
//            publisherDto.setTagmembername(interviewerEntity.getTagMemberName());
//            publisherDto.setTagEmailId(interviewerEntity.getTagEmailId());
//            publisherDto.setCandidatename(interviewerEntity.getCandidateName());
//            publisherDto.setCandidateEmailId(interviewerEntity.getCandidateEmailId());
            publisherDto.setMessageText("");
            publisherDto.setStartTime(new SimpleDateFormat("HH:mm:ss").parse(interviewerEntity.getStart_time()));
            publisherDto.setEndTime(new SimpleDateFormat("HH:mm:ss").parse(interviewerEntity.getEnd_time()));
            publisherDto.setDate(interviewerEntity.getSlot_date());
            template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, publisherDto);
            System.out.println("DATA sent successfully: " + publisherDto);
        } catch (Exception e) {
            throw new Exception("Something went bad in publishing message to queue" + e);
        }
        return true;
    }

}
