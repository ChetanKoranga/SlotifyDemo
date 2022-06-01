package com.stackroute.repository;

import com.stackroute.Models.Interviewer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewerRepo extends MongoRepository<Interviewer, String> {

    List<Interviewer> findByTechTrack(String techTrack);


}
