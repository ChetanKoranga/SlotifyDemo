package com.stackroute.interviewerservice.controller;

import com.stackroute.interviewerservice.Exception.RecordNotFound;
import com.stackroute.interviewerservice.Exception.profileAlreadyExists;
import com.stackroute.interviewerservice.Exception.interviewIdNotExists;
import com.stackroute.interviewerservice.model.InterviewerEntity;
import com.stackroute.interviewerservice.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")



public class InterviewController {
    @Autowired
    private InterviewService interviewservice;

    @PostMapping
    public InterviewerEntity addingNewSlot(@RequestBody InterviewerEntity interviewerEntity) throws interviewIdNotExists {
        return interviewservice.createInterview(interviewerEntity);
    }

    @PutMapping
    public ResponseEntity<InterviewerEntity> updatingSlot(@RequestBody InterviewerEntity interviewerEntity) throws profileAlreadyExists {
        interviewerEntity.setSlot_id(interviewerEntity.getSlot_id());
        return ResponseEntity.ok().body(this.interviewservice.updateInterview(interviewerEntity));
    }

    @GetMapping("/{interviewer_emailId}")
    public ResponseEntity<List<InterviewerEntity>> getingSlot(@PathVariable String interviewer_emailId) {
        List<InterviewerEntity> interviewerEntity = interviewservice.getByInterviewerEmailId(interviewer_emailId);
        return new ResponseEntity<>(interviewerEntity, HttpStatus.IM_USED);
    }

    @DeleteMapping("/{slot_id}")
    public HttpStatus deleteById(@PathVariable String slot_id) throws  RecordNotFound {
        this.interviewservice.deleteById(slot_id);
        return HttpStatus.OK;
    }

}