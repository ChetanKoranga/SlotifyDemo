/*
author: chetan.koranga,
date of creation: 30/05/22
*/

package com.stackroute.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListner {

    public static final String USER_AUTH_DATA = "user_auth_data";

    @RabbitListener(queues= USER_AUTH_DATA)
        public void consumeMessageFromQueue(ConsumerDTO consumerDTO) {
            System.out.println("Message received from queue: " +  consumerDTO);
        }
}