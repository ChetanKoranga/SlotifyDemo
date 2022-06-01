package com.stackroute.service;

import com.stackroute.Models.Candidate;
import com.stackroute.Models.Interviewer;
import com.stackroute.Models.TAGMemeber;
import com.stackroute.exceptions.AlreadyExitException;
import com.stackroute.exceptions.ResourceNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {

    Interviewer registerInterviewer(Interviewer interviewer)throws AlreadyExitException;
    TAGMemeber registerTAGMember (TAGMemeber tagMemeber);

    Candidate registerCandidate(Candidate candidate);

    Interviewer updateInterviewer(Interviewer interviewer)throws ResourceNotFoundException;

    TAGMemeber updateTAGMember(TAGMemeber tagMemeber);

    Candidate updateCandidate(Candidate candidate);

  //List<Interviewer> findByTechTrack(String techTrack);
    List<Interviewer> getByTechTrack(String techTrack);

}
