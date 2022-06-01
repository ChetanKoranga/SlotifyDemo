package com.stackroute.repository;

import com.stackroute.Models.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CandidateRepo extends MongoRepository<Candidate,String> {


}
