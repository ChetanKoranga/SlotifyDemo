package com.stackroute.services;

import com.stackroute.model.Job;
import com.stackroute.model.JobApplication;

import java.util.List;


public interface CandidateServices {
    List<Job> findAll();
     Job save(Job job);
    List<Job> findByTagMemberEmailId(String tagMemberEmailId);


//    Optional<Job> findByJobTitle(String jobTitle);
    List<JobApplication> findBytagMemberEmailId(String tagMemberEmailId);

    Job UpdateJob(Job job);

    JobApplication UpdateJobApplication(JobApplication jobApplication);

    JobApplication saveapp(JobApplication jobApplication);






}
