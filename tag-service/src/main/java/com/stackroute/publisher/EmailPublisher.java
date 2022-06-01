/*
author: chetan.koranga,
date of creation: 31/05/22
*/

package com.stackroute.publisher;

import com.stackroute.Config.MessagingConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
public class EmailPublisher {

    @Autowired
    RabbitTemplate template;

    public boolean saveUserDetails(ProducerDto producerDTO) throws Exception {
        try {
            System.out.println("Sent to queue:  " + producerDTO);
            template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, producerDTO);
        } catch (Exception e) {
            throw new Exception("Something went bad in publishing message to queue" + e);
        }
//        order.setOrderId(UUID.randomUUID().toString());s
//        ProducerDTO producerDTO = new OrderStatus(order, "PROGRESS", "Your order is received and is in progress with the restaurant " + restaurantName);
        return true;
    }
}
