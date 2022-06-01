/*
author: chetan.koranga,
date of creation: 30/05/22
*/

package com.stackroute.consumer;

import com.stackroute.Dto.AuthenticationServiceDto;
import com.stackroute.Repository.AuthenticationServiceRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {


    @Autowired
    private AuthenticationServiceRepository authenticationServiceRepository;

    public static final String USER_AUTH_DATA = "user_auth_data";

    @RabbitListener(queues = USER_AUTH_DATA)
    public void consumeMessageFromQueue(ConsumerDTO consumerDTO) throws Exception {
        try{
            AuthenticationServiceDto authenticationServiceDto = new AuthenticationServiceDto();
            System.out.println("Message received from queue: " + consumerDTO.toString());
            System.out.println(consumerDTO.toString());
            authenticationServiceDto.setUserName(consumerDTO.getUserName());
            authenticationServiceDto.setPassword(consumerDTO.getPassword());
            authenticationServiceDto.setUserRole(consumerDTO.getUserRole());
            authenticationServiceDto.setEmail(consumerDTO.getEmail());
            authenticationServiceRepository.save(authenticationServiceDto);
        }
        catch (Exception e){
            throw new Exception(e);
        }
    }
}