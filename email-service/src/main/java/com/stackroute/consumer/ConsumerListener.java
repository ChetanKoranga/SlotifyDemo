/*
author: chetan.koranga,
date of creation: 30/05/22
*/

package com.stackroute.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {


    public static final String EMAIL_NOTIFICATION_TO_INTERVIEWER = "email_notification_to_interviewer";
    public static final String EMAIL_NOTIFICATION_TO_TAG = "email_notification_to_tag";


    @RabbitListener(queues = EMAIL_NOTIFICATION_TO_INTERVIEWER)
    public void emailToInterviewer(ConsumerDto consumerDTO) throws Exception {
        try{
            System.out.println("Received Message: "+consumerDTO);
        }
        catch (Exception e){
            throw new Exception(e);
        }
    }

//    @RabbitListener(queues = EMAIL_NOTIFICATION_TO_TAG)
//    public void emailToTag(ConsumerDto consumerDTO) throws Exception {
//        try{
//            System.out.println("");
//        }
//        catch (Exception e){
//            throw new Exception(e);
//        }
//    }
}