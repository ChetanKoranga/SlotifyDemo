package com.stackroute.services;

import com.stackroute.exceptionhandler.DataAlreadyExistsException;
import com.stackroute.exceptionhandler.NoSuchDataExistsException;
import com.stackroute.model.Job;
import com.stackroute.model.JobApplication;
import com.stackroute.repositories.CandidateRepository;
import com.stackroute.repositories.JobRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CandidateServicesIMPL implements CandidateServices {
       @Autowired
    private JobRepositoy jobrepo;
      @Autowired
    private CandidateRepository AppRepo;


    @Override  //returns list of all job posted
    public List<Job> findAll() {
           List<Job> job = jobrepo.findAll();
          if ((job.isEmpty())){
              throw new NoSuchDataExistsException("No jobs Posted Yet");
          }else

              return jobrepo.findAll();
    }




//    @Override
//    public Optional<Job> findByJobTitle(String jobTitle) {
//
//        return jobrepo.findByJobTitle(jobTitle);
//    }

    @Override //method returns list of job Application posted via. tagmember email if none is registered with the email then returns NosuchDataFound exception
    public List<JobApplication> findBytagMemberEmailId(String tagMemberEmailId) {
        List <JobApplication> jobApplication = AppRepo.findByTagMemberEmailId(tagMemberEmailId);
        if(jobApplication.isEmpty()){
            throw new NoSuchDataExistsException("NO job registered to this email  or email doesnt exist"+":"+tagMemberEmailId);
        }

        return AppRepo.findByTagMemberEmailId(tagMemberEmailId);

    }




    @Override// method Updates Job application data via. job posting ID if no Id is found then returns NoSuchDataExist Exception
    public Job UpdateJob(Job job) throws NoSuchDataExistsException{

 if (jobrepo.existsById(job.getJob_posting_id())){
        Job avail = jobrepo.findById(job.getJob_posting_id()).get();


           // Job jobUpdate = avail.get();
            avail.setJobTitle(job.getJobTitle());
            avail.setJob_post_status(job.getJob_post_status());
            avail.setTag_member_name(job.getTag_member_name());
            avail.setTag_team_name(job.getTag_team_name());
            avail.setTagMemberEmailId(job.getTagMemberEmailId());
            jobrepo.save(avail);
            return avail;
        } else {
            throw new NoSuchDataExistsException("Record not found with  JOBId : " + job.getJob_posting_id());
        }
    }

    @Override// method Updates Job posted data via. job posting ID if no Id is found then returns NoSuchDataExist Exception
    public JobApplication UpdateJobApplication(JobApplication jobApplication) {
        if (AppRepo.existsById(jobApplication.getApplicationId())){

              JobApplication appavail = AppRepo.findById(jobApplication.getApplicationId()).get();


            appavail.setGd(jobApplication.getGd());
            appavail.setShortlisted(jobApplication.getShortlisted());
            appavail.setInterview(jobApplication.getInterview());
            appavail.setStatus(jobApplication.getStatus());
            AppRepo.save(appavail);
            return appavail;
        } else {
            throw new NoSuchDataExistsException("Record not found with  JOBId : " + jobApplication.getApplicationId());
        }
    }

    @Override//method saves new job application and returns DataAlready exception if Application already exist
    public JobApplication save(JobApplication jobApplication) throws DataAlreadyExistsException{

        Optional < JobApplication > title =this.AppRepo.findById(jobApplication.getApplicationId());
        if (title.isPresent())

            throw new DataAlreadyExistsException("Record already present with Application ID :"+ jobApplication.getApplicationId()+new ResponseEntity<>("JobTittle already present",HttpStatus.CONFLICT) );       else {
           //  jobApplication.setApplicationId(generateUUID());
        return AppRepo.save(jobApplication);

    }}

//    @Override
//    public Optional<JobApplication> findById(String applicationId) {
//        return Optional.empty();
//    }


    @Override//method saves new job posting and returns DataAlready exception if Job already exist via. jobtitle
    public Job save(Job job) {

        Optional < Job > title =this.jobrepo.findByJobTitle(job.getJobTitle());
        if (title.isPresent()) {
            throw new DataAlreadyExistsException("Job title Already Exists with jobTitle"+" : " + job.getJobTitle());
           // throw new Resourcefound("Record already present with JOB TITLE :"+ job.getJobTitle()+new ResponseEntity<>("JobTittle already present",HttpStatus.CONFLICT) );
            } else {

          //job.setJob_posting_id(generateUUID());
            return jobrepo.save(job);
        }


}

    @Override  //method returns list of job posted via. tagmember email if none is registered with the email then returns NosuchDataFound exception
    public List<Job> findByTagMemberEmailId(String tagMemberEmailId) {
       List <Job> job = jobrepo.findByTagMemberEmailId(tagMemberEmailId);
       if(job.isEmpty()){
           throw new NoSuchDataExistsException("NO job registered to this email  or email doesnt exist"+":"+tagMemberEmailId);
       }

        return jobrepo.findByTagMemberEmailId(tagMemberEmailId);
    }

    public UUID generateUUID() {
        return UUID.randomUUID();

}}

