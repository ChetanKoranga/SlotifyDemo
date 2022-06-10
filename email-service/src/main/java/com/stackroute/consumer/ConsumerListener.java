/*
author: chetan.koranga,
date of creation: 30/05/22
*/

package com.stackroute.consumer;

import com.stackroute.config.MessagingConfig;
import com.stackroute.model.Email;
import com.stackroute.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {

    @RabbitListener(queues = MessagingConfig.EMAIL_NOTIFICATION_QUEUE)
    public void emailToInterviewer(ConsumerDto consumerDTO) throws Exception {
        try {

            EmailService emailService = new EmailService();
            Email email = new Email();
            email.setCandidateEmailId(consumerDTO.getCandidateEmailId());
            email.setIntervierEmailId(consumerDTO.getIntervierEmailId());
            email.setCandidatename(consumerDTO.getCandidatename());
            email.setInterviername(consumerDTO.getInterviername());
            email.setTagEmailId(consumerDTO.getTagEmailId());
            email.setDate(consumerDTO.getDate());
            email.setStartTime(consumerDTO.getStartTime());
            email.setMessageText(consumerDTO.getMessageText());
            email.setEndTime(consumerDTO.getEndTime());
            email.setSubject(consumerDTO.getSubject());
            email.setTagmembername(consumerDTO.getTagmembername());
            emailService.sendEmail(email);

        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}