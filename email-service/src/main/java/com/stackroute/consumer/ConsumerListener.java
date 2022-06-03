/*
author: chetan.koranga,
date of creation: 30/05/22
*/

package com.stackroute.consumer;

import com.stackroute.config.MessagingConfig;
import com.stackroute.model.Email;
import com.stackroute.service.EmailService;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {

    @RabbitListener(queues = MessagingConfig.EMAIL_NOTIFICATION_QUEUE)
    public void emailToInterviewer(ConsumerDto consumerDTO) throws Exception {
        try {
            ModelMapper modelMapper = new ModelMapper();
            EmailService emailService = new EmailService();
              Email email = modelMapper.map(consumerDTO,Email.class);
            emailService.sendEmail(email);

        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}