/*
author: chetan.koranga,
date of creation: 31/05/22
*/

package com.stackroute.publisher;

import com.stackroute.Config.MessagingConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
public class UserPublisher {

    @Autowired
    RabbitTemplate template;

    public boolean saveUserDetails(ProducerDto producerDTO) throws Exception {
        try {
            System.out.println("Sent to queue:  " + producerDTO);
            template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, producerDTO);
        } catch (Exception e) {
            throw new Exception("Something went bad in publishing message to queue" + e);
        }
        return true;
    }
}
