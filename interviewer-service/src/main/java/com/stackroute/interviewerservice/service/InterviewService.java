package com.stackroute.interviewerservice.service;

import com.stackroute.interviewerservice.Exception.RecordNotFound;
import com.stackroute.interviewerservice.Exception.profileAlreadyExists;
import com.stackroute.interviewerservice.Exception.interviewIdNotExists;
import com.stackroute.interviewerservice.model.InterviewerEntity;

import java.util.List;

public interface InterviewService {
     List<InterviewerEntity> getByInterviewerEmailId(String interviewer_emailId) ;


     InterviewerEntity createInterview(InterviewerEntity interviewerEntity) throws interviewIdNotExists;

     InterviewerEntity updateInterview(InterviewerEntity interviewerEntity) throws profileAlreadyExists;
     public InterviewerEntity deleteById(String slot_id)throws RecordNotFound;






}
