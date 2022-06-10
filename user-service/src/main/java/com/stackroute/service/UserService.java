package com.stackroute.service;

import com.stackroute.DTOs.CandidateDto;
import com.stackroute.DTOs.InterviewerDto;
import com.stackroute.DTOs.TAGMemeberDto;
import com.stackroute.Models.Candidate;
import com.stackroute.Models.Interviewer;
import com.stackroute.Models.TAGMemeber;
import com.stackroute.exceptions.AlreadyExitException;
import com.stackroute.exceptions.ResourceNotFoundException;

import java.util.List;

public interface UserService {

    Interviewer registerInterviewer(InterviewerDto interviewer)throws AlreadyExitException;
    TAGMemeberDto registerTAGMember (TAGMemeberDto tagMemeber) throws Exception;

    Candidate registerCandidate(CandidateDto candidate) throws Exception;

    Interviewer updateInterviewer(Interviewer interviewer)throws ResourceNotFoundException;

    TAGMemeber updateTAGMember(TAGMemeber tagMemeber)throws  ResourceNotFoundException;

    Candidate updateCandidate(CandidateDto candidateDto) throws Exception;

  //List<Interviewer> findByTechTrack(String techTrack);
    List<Interviewer> getByTechTrack(String techTrack);

}
