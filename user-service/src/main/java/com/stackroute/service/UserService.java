package com.stackroute.service;

import com.stackroute.DTOs.InterviewerDto;
import com.stackroute.DTOs.TAGMemeberDto;
import com.stackroute.Models.Candidate;
import com.stackroute.Models.Interviewer;
import com.stackroute.Models.TAGMemeber;
import com.stackroute.exceptions.AlreadyExitException;
import com.stackroute.exceptions.ResourceNotFoundException;

import java.util.List;

public interface UserService {

    InterviewerDto registerInterviewer(InterviewerDto interviewer)throws AlreadyExitException;
    TAGMemeberDto registerTAGMember (TAGMemeberDto tagMemeber) throws Exception;

    Candidate registerCandidate(Candidate candidate);

    Interviewer updateInterviewer(Interviewer interviewer)throws ResourceNotFoundException;

    TAGMemeber updateTAGMember(TAGMemeber tagMemeber);

    Candidate updateCandidate(Candidate candidate);

  //List<Interviewer> findByTechTrack(String techTrack);
    List<Interviewer> getByTechTrack(String techTrack);

}
