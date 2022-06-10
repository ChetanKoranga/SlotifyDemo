package com.stackroute.controller;

import com.stackroute.model.Job;
import com.stackroute.model.JobApplication;
import com.stackroute.services.CandidateServices;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
@RefreshScope
public class CandidateController {



    @Autowired
    private CandidateServices serv;


    @PostMapping("/jobpost")//calls the method in service layer to save new data of job postings
    public ResponseEntity<Job> save(@RequestBody Job job) {

        return ResponseEntity.ok().body(this.serv.save(job));
    }


    @PutMapping ("/Updatejob")//calls the method in service layer to update existing data
    public ResponseEntity <?> updatejobpostiong(@RequestBody Job job) {
        serv.UpdateJob(job);
        return new ResponseEntity<>("Updated Successfully ", HttpStatus.OK);
    }
    @PostMapping("/jobApp")//calls the method in service layer to  save new job application
    public ResponseEntity<JobApplication> save(@RequestBody JobApplication jobApplication) {
        //jobApplication.setApplicationId(jobApplication.getApplicationId());
        return ResponseEntity.ok().body(this.serv.saveapp(jobApplication));
    }


    @PutMapping("/Updatejobapp")//calls the service layer method to update the existing job application
    public ResponseEntity<?> updatejobapp(@RequestBody JobApplication jobApplication) {
               serv.UpdateJobApplication(jobApplication);
        return new ResponseEntity<>("Job Application Updated", HttpStatus.OK);
    }

    @GetMapping("postdjobs/{tagMemberEmailId}") //calls the method in service layer  to fetch all job posted via. tag member email id
    public ResponseEntity<?> getByTagMemberEmailId(@PathVariable String tagMemberEmailId){

        return new ResponseEntity<>( serv.findByTagMemberEmailId(tagMemberEmailId), HttpStatus.OK);
    }

    @GetMapping("jobApppostd/{tagMemberEmailId}") // calls  the method in service layer to fetch all job Application via. tag member email id
    public ResponseEntity<?> getjobpostdtagByemailId(@PathVariable String tagMemberEmailId) {

        return new ResponseEntity<>(serv.findBytagMemberEmailId(tagMemberEmailId), HttpStatus.OK);
    }

    @GetMapping("/findall") //calls  the method in service layer to fetch all job posted
    public ResponseEntity<?> Findall() {
        List<Job> job = serv.findAll();
        return new ResponseEntity<>(job, HttpStatus.OK);
    }
}
