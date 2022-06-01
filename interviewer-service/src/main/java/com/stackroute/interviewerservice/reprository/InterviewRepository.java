package com.stackroute.interviewerservice.reprository;

import com.stackroute.interviewerservice.model.InterviewerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepository extends MongoRepository <InterviewerEntity,String>{
@Query("{interviewer_emailId : ?0}")
    List<InterviewerEntity> findByInterviewerEmailId(String interviewer_emailId);
}
