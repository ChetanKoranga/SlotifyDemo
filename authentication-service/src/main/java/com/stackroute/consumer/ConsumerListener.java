/*
author: chetan.koranga,
date of creation: 30/05/22
*/

package com.stackroute.consumer;

import com.stackroute.Dto.AuthenticationServiceDto;
import com.stackroute.Model.AuthenticationServiceModel;
import com.stackroute.Repository.AuthenticationServiceRepository;
import com.stackroute.Service.AuthenticationServiceInterface;
import com.stackroute.Service.AuthenticationServiceInterfaceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsumerListener {


    @Autowired
    private AuthenticationServiceRepository authenticationServiceRepository;

    @Autowired
    AuthenticationServiceInterfaceImpl authenticationService;

    @Autowired
    private ModelMapper modelMapper;
    public static final String USER_AUTH_DATA = "user_auth_data";

    @RabbitListener(queues = USER_AUTH_DATA)
    public void consumeMessageFromQueue(ConsumerDTO consumerDTO) throws Exception {
        try {
            List<AuthenticationServiceDto> email = authenticationServiceRepository.findByEmail(consumerDTO.getEmail());
            System.out.println("Message received from queue: " + consumerDTO.toString());
            AuthenticationServiceDto authenticationServiceDto = modelMapper.map(consumerDTO, AuthenticationServiceDto.class);
            AuthenticationServiceModel authenticationServiceModel = modelMapper.map(authenticationServiceDto, AuthenticationServiceModel.class);
            System.out.println("**** EMAIL ****" + email.toString());

            //  for new user
            if (email.isEmpty()) {
                System.out.println("=====NEW USER TRIGGERED=====");
                authenticationService.NewUser(authenticationServiceModel);
            }

            //  for updating existing user
            else {
                System.out.println("=====UPDATING TRIGGERED=====");
                int userId = email.get(0).getUserId();
                System.out.println("**** It is a user ID ****" + userId);
                authenticationService.UpdatingUser(authenticationServiceDto, userId);
            }

        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}