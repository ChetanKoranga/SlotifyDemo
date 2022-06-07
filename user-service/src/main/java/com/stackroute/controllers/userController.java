package com.stackroute.controllers;

import com.stackroute.DTOs.CandidateDto;
import com.stackroute.DTOs.InterviewerDto;
import com.stackroute.DTOs.TAGMemeberDto;
import com.stackroute.Models.Candidate;
import com.stackroute.Models.Interviewer;
import com.stackroute.Models.TAGMemeber;
import com.stackroute.exceptions.AlreadyExitException;
import com.stackroute.exceptions.ResourceNotFoundException;
import com.stackroute.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userservice")
public class userController {

    @Autowired
    private UserService userService;


    //registering new interviewer
    @PostMapping("/register-interviewer")
    public ResponseEntity<?> registerInterviewer(@RequestBody InterviewerDto interviewerDto) throws AlreadyExitException {
        userService.registerInterviewer(interviewerDto);
        return new ResponseEntity<>("Registration Successful", HttpStatus.CREATED);
    }

    //registering new TAG team member
    @PostMapping("/register-TAGMember")
    public ResponseEntity<?> registerTAGMember(@RequestBody TAGMemeberDto tagMemeberDto) throws Exception {
        userService.registerTAGMember(tagMemeberDto);
        return new ResponseEntity<>("Registration Successful", HttpStatus.CREATED);
    }
   /* @PostMapping("/register-Candidate")
    public ResponseEntity<CandidateDto> registerCandidate(@RequestBody CandidateDto candidateDto) {

    Candidate candidateReqest = modelMapper.map(candidateDto, Candidate.class);
    Candidate candidate = userService.registerCandidate(candidateReqest);
    CandidateDto candidateResponse = modelMapper.map(candidate, CandidateDto.class);

     return new ResponseEntity<CandidateDto>(candidateResponse, HttpStatus.CREATED);



      }*/
     @PostMapping("/register-Candidate")
     public ResponseEntity<Candidate> registerCandidate (@RequestBody CandidateDto candidateDto) throws Exception {
         userService.registerCandidate(candidateDto);
         return ResponseEntity.status(HttpStatus.CREATED).build();
      }

             // updating interviewer

         @PutMapping("/updateinterviewer/{emailId}")
    public ResponseEntity<Interviewer> updateinterviewerdetails(@PathVariable String emailId, @RequestBody Interviewer interviewer) throws ResourceNotFoundException {
        interviewer.setEmailId(emailId);
        return ResponseEntity.ok().body(this.userService.updateInterviewer(interviewer));
    }


    //updating TAG team member

    @PutMapping("/updatetagmember/{emailId}")
    public ResponseEntity<TAGMemeber> updatetagmemberdetails(@PathVariable String emailId, @RequestBody TAGMemeber tagMemeber) {
        tagMemeber.setEmailId(emailId);
        return ResponseEntity.ok().body(this.userService.updateTAGMember(tagMemeber));
    }

    @PutMapping("/updatecandidate/{emailId}")
    public ResponseEntity<Candidate> updatecandidatedetails(@PathVariable String emailId, @RequestBody CandidateDto candidateDto) throws Exception {
        candidateDto.setEmailId(emailId);
        return ResponseEntity.ok().body(this.userService.updateCandidate(candidateDto));
    }
    //interviewers based on techtrack


    @GetMapping("/findBytechtrack/{techTrack}")
    public ResponseEntity<List<Interviewer>> getByTechTrack(@PathVariable String techTrack) {
          userService.getByTechTrack(techTrack);
        return new ResponseEntity<>(userService.getByTechTrack(techTrack), HttpStatus.IM_USED);

    }

}





