package com.stackroute.repositories;

import com.stackroute.model.Job;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JobRepositoy extends MongoRepository<Job, String> {


   Optional <Job>findByJobTitle(String jobTitle);



   List<Job> findByTagMemberEmailId(String tagMemberEmailId);
}
