package com.stackroute.interviewerservice.reprository;

import com.stackroute.interviewerservice.model.InterviewerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SlotRepository extends MongoRepository<InterviewerEntity,String> {

}
