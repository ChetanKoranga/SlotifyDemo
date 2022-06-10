package com.stackroute.service;

import com.stackroute.DTOs.InterviewerDto;
import com.stackroute.DTOs.TAGMemeberDto;
import com.stackroute.Models.Candidate;
import com.stackroute.Models.Interviewer;
import com.stackroute.Models.TAGMemeber;
import com.stackroute.exceptions.AlreadyExitException;
import com.stackroute.exceptions.ResourceNotFoundException;
import com.stackroute.publisher.ProducerDto;
import com.stackroute.publisher.UserPublisher;
import com.stackroute.repository.CandidateRepo;
import com.stackroute.repository.InterviewerRepo;
import com.stackroute.repository.TAGMemeberRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


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


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    UserPublisher userPublisher;


    @Override
    public Interviewer registerInterviewer(InterviewerDto interviewerDto) throws AlreadyExitException {
        Interviewer interviewer;
        InterviewerDto interviewerResoponse;
        if (this.interviewerRepo.findById(interviewerDto.getEmailId()).isPresent()) {
            throw new AlreadyExitException();
        } else {
            Interviewer interviewerRequest = modelMapper.map(interviewerDto, Interviewer.class);
            try {
                ProducerDto producerDTO = new ProducerDto();
                producerDTO.setEmail(interviewerDto.getEmailId());
                producerDTO.setUserName(interviewerDto.getFirstName() + " " + interviewerDto.getLastName());
                producerDTO.setUserRole("Interviewer");
                producerDTO.setPassword(new BCryptPasswordEncoder().encode(interviewerDto.getPassword()));
                userPublisher.saveUserDetails(producerDTO);
                interviewer = interviewerRepo.save(interviewerRequest);
                interviewerResoponse = modelMapper.map(interviewer, InterviewerDto.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return interviewer;
        }
    }

    @Override
    public TAGMemeberDto registerTAGMember(TAGMemeberDto tagMemeberDto) throws Exception {
        TAGMemeber tagMemeber;
        TAGMemeberDto tagmemberResponse;
        ProducerDto producerDTO = new ProducerDto();
        producerDTO.setEmail(tagMemeberDto.getEmailId());
        producerDTO.setUserName(tagMemeberDto.getFirstName() + " " + tagMemeberDto.getLastName());
        producerDTO.setUserRole("TAG");
        producerDTO.setPassword(new BCryptPasswordEncoder().encode(tagMemeberDto.getPassword()));
        userPublisher.saveUserDetails(producerDTO);
        TAGMemeber tagMemeberRequest = modelMapper.map(tagMemeberDto, TAGMemeber.class);
        tagMemeber = tagMemeberRepo.save(tagMemeberRequest);
        tagmemberResponse = modelMapper.map(tagMemeber, TAGMemeberDto.class);
        return tagmemberResponse;
    }

    @Override
    public Candidate registerCandidate(Candidate candidate) {
        return candidateRepo.save(candidate);
    }


    @Override
    public Interviewer updateInterviewer(Interviewer interviewer) throws ResourceNotFoundException {

        //Optional<Interviewer> Slotify1 = this.interviewerRepo.findById(interviewer.getEmailId());
        if (interviewerRepo.existsById(interviewer.getEmailId())) {


            return interviewerRepo.save(interviewer);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @Override

    public TAGMemeber updateTAGMember(TAGMemeber tagMemeber) throws ResourceNotFoundException{

       // Optional<TAGMemeber> Slotify1 = this.tagMemeberRepo.findById(tagMemeber.getEmailId());
        if (tagMemeberRepo.existsById(tagMemeber.getEmailId())) {

            return tagMemeberRepo.save(tagMemeber);

        }else {
            throw new ResourceNotFoundException();
        }
//        TAGMemeber editTAGMember = Slotify1.get();
//        editTAGMember.setEmailId(tagMemeber.getEmailId());
//        editTAGMember.setFirstName(tagMemeber.getFirstName());
//        editTAGMember.setLastName(tagMemeber.getLastName());
//        tagMemeberRepo.save(editTAGMember);
//        return editTAGMember;
    }

    @Override
    public Candidate updateCandidate(Candidate candidate) {

        Optional<Candidate> Slotify2 = this.candidateRepo.findById(candidate.getEmailId());
        Candidate editCandidte = Slotify2.get();
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







