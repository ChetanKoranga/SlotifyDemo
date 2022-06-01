package com.stackroute.service;

import com.stackroute.Models.Candidate;
import com.stackroute.Models.Interviewer;
import com.stackroute.Models.TAGMemeber;
import com.stackroute.exceptions.AlreadyExitException;
import com.stackroute.exceptions.ResourceNotFoundException;
import com.stackroute.repository.CandidateRepo;
import com.stackroute.repository.InterviewerRepo;
import com.stackroute.repository.TAGMemeberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private InterviewerRepo interviewerRepo;

    @Autowired
    private TAGMemeberRepo tagMemeberRepo;

    @Autowired
    private CandidateRepo candidateRepo;

    @Override
    public Interviewer registerInterviewer(Interviewer interviewer)throws AlreadyExitException {
        if (this.interviewerRepo.findById(interviewer.getEmailId()).isPresent()) {
            throw new AlreadyExitException();
        } else {
            return interviewerRepo.save(interviewer);
        }
    }

    @Override
    public TAGMemeber registerTAGMember(TAGMemeber tagMemeber) {
        return tagMemeberRepo.save(tagMemeber);
    }

    @Override
    public Candidate registerCandidate(Candidate candidate) {
        return candidateRepo.save(candidate);
    }


    @Override
    public Interviewer updateInterviewer(Interviewer interviewer) throws ResourceNotFoundException {

        Optional<Interviewer> Slotify1=this.interviewerRepo.findById(interviewer.getEmailId());
        if (this.interviewerRepo.findById(interviewer.getEmailId()).isPresent()) {
        Interviewer editInterviewer=Slotify1.get();
        editInterviewer.setEmailId(interviewer.getEmailId());
        editInterviewer.setFirstName(interviewer.getFirstName());
        editInterviewer.setLastName(interviewer.getLastName());
        editInterviewer.setMobileNumber(interviewer.getMobileNumber());
        editInterviewer.setTechTrack(interviewer.getTechTrack());
        interviewerRepo.save(editInterviewer);
        return editInterviewer;
    }else{
            throw new ResourceNotFoundException();
        }
    }

    @Override

    public TAGMemeber updateTAGMember(TAGMemeber tagMemeber) {

        Optional<TAGMemeber> Slotify1=this.tagMemeberRepo.findById(tagMemeber.getEmailId());
        TAGMemeber editTAGMember=Slotify1.get();
        editTAGMember.setEmailId(tagMemeber.getEmailId());
        editTAGMember.setFirstName(tagMemeber.getFirstName());
        editTAGMember.setLastName(tagMemeber.getLastName());
        tagMemeberRepo.save(editTAGMember);
        return editTAGMember;
    }

    @Override
    public Candidate updateCandidate(Candidate candidate) {

        Optional<Candidate> Slotify2=this.candidateRepo.findById(candidate.getEmailId());
        Candidate editCandidte=Slotify2.get();
        editCandidte.setEmailId(candidate.getEmailId());
        editCandidte.setFirstName(candidate.getFirstName());
        editCandidte.setLastName(candidate.getLastName());
        editCandidte.setMobileNumber(candidate.getMobileNumber());
        editCandidte.setCurrentCtc(candidate.getCurrentCtc());
        candidateRepo.save(editCandidte);
        return editCandidte;
    }


    @Override
    public List<Interviewer> getByTechTrack(String techTrack) {
        return interviewerRepo.findByTechTrack(techTrack);
    }
    }







