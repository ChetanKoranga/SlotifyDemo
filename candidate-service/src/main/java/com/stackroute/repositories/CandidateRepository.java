package com.stackroute.repositories;

import com.stackroute.model.JobApplication;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface CandidateRepository extends MongoRepository<JobApplication, String> {
    List<JobApplication> findByTagMemberEmailId(String tagMemberEmailId);
}
