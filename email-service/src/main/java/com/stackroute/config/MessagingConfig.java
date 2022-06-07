/*
author: chetan.koranga,
date of creation: 16/05/22
*/

package com.stackroute.config;


import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {
    public static final String EMAIL_NOTIFICATION_QUEUE = "email_notification_queue";
    public static final String QUEUE = EMAIL_NOTIFICATION_QUEUE;

//    public static final String EXCHANGE = "user_auth_exchange";
//    public static final String ROUTING_KEY = "user_auth_routing_key";
//
//    @Bean
//    public Queue queue(){
//        return new Queue(QUEUE);
//    }

//    @Bean
//    public TopicExchange exchange(){
//        return new TopicExchange(EXCHANGE);
//    }


    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

}