/*
author: chetan.koranga,
date of creation: 31/05/22
*/

package com.stackroute.publisher;

import com.stackroute.Config.MessagingConfig;
import com.stackroute.models.SlotUpdate;
import com.stackroute.models.SlotsBooked;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
public class EmailPublisher {

    @Autowired
    RabbitTemplate template;

    public boolean sendBookedSlotDetails(SlotsBooked slotsBooked) throws Exception {
        PublisherDto publisherDto = new PublisherDto();
        try {
            System.out.println("Sent to queue:  " + slotsBooked);
            publisherDto.setSubject("Your slot is booked");
            publisherDto.setInterviername(slotsBooked.getInterviewerName());
            publisherDto.setIntervierEmailId(slotsBooked.getInterviewerEmailId());
            publisherDto.setTagmembername(slotsBooked.getTagMemberName());
            publisherDto.setTagEmailId(slotsBooked.getTagEmailId());
            publisherDto.setCandidatename(slotsBooked.getCandidateName());
            publisherDto.setCandidateEmailId(slotsBooked.getCandidateEmailId());
            publisherDto.setMessageText("");
            publisherDto.setStartTime(slotsBooked.getStartTime());
            publisherDto.setEndTime(slotsBooked.getEndTime());
            publisherDto.setDate(slotsBooked.getBookedDate());
            template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, publisherDto);
            System.out.println("DATA sent successfully: " + publisherDto);
        } catch (Exception e) {
            throw new Exception("Something went bad in publishing message to queue" + e);
        }
        return true;
    }

    public boolean sendUpdatedSlotDetails(SlotsBooked slotsBooked) throws Exception {
        PublisherDto publisherDto = new PublisherDto();
        try {
            System.out.println("Sent to queue:  " + slotsBooked);
            publisherDto.setSubject("Your slot is cancelled");
            publisherDto.setInterviername(slotsBooked.getInterviewerName());
            publisherDto.setIntervierEmailId(slotsBooked.getInterviewerEmailId());
            publisherDto.setTagmembername(slotsBooked.getTagMemberName());
            publisherDto.setTagEmailId(slotsBooked.getTagEmailId());
            publisherDto.setCandidatename(slotsBooked.getCandidateName());
            publisherDto.setCandidateEmailId(slotsBooked.getCandidateEmailId());
            publisherDto.setMessageText("");
            publisherDto.setStartTime(slotsBooked.getStartTime());
            publisherDto.setEndTime(slotsBooked.getEndTime());
            publisherDto.setDate(slotsBooked.getBookedDate());
            template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, publisherDto);
            System.out.println("Updated DATA sent successfully: " + publisherDto);
        } catch (Exception e) {
            throw new Exception("Something went bad in publishing message to queue" + e);
        }
        return true;
    }

}
