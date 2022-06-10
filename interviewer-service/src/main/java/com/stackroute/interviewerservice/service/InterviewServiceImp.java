package com.stackroute.interviewerservice.service;

import com.stackroute.interviewerservice.Exception.RecordNotFound;
import com.stackroute.interviewerservice.Exception.profileAlreadyExists;
import com.stackroute.interviewerservice.Exception.interviewIdNotExists;

import com.stackroute.interviewerservice.model.InterviewerEntity;

import com.stackroute.interviewerservice.reprository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class InterviewServiceImp implements InterviewService{
    @Autowired
    private InterviewRepository interviewRepository;

    @Override
    public List<InterviewerEntity> getByInterviewerEmailId(String interviewer_emailId) {

        return interviewRepository.findByInterviewerEmailId(interviewer_emailId);
    }




    @Override
    public InterviewerEntity createInterview(InterviewerEntity interviewerEntity) throws interviewIdNotExists {
        interviewerEntity.setSlot_id(interviewerEntity.getSlot_id());
        if(this.interviewRepository.findById(interviewerEntity.getSlot_id()).isPresent())  {
            throw new interviewIdNotExists();

        }else{
            return interviewRepository.save(interviewerEntity);
    }
    }



    @Override

    public InterviewerEntity updateInterview(InterviewerEntity interviewerEntity) throws profileAlreadyExists {
        Optional<InterviewerEntity> schedulseeasy = this.interviewRepository.findById(interviewerEntity.getSlot_id());
        if (this.interviewRepository.findById(interviewerEntity.getSlot_id()).isPresent()) {

            InterviewerEntity updateSlot = schedulseeasy.get();
            updateSlot.setSlot_id(interviewerEntity.getSlot_id());
            updateSlot.setInterviewer_emailId(interviewerEntity.getInterviewer_emailId());
            updateSlot.setMeeting_venue(interviewerEntity.getMeeting_venue());
            updateSlot.setMeeting_link(interviewerEntity.getMeeting_link());
            updateSlot.setSlot_status(interviewerEntity.getSlot_status());
            updateSlot.setSlot_date(interviewerEntity.getSlot_date());
            updateSlot.setStart_time(interviewerEntity.getStart_time());
            updateSlot.setEnd_time(interviewerEntity.getEnd_time());
            interviewRepository.save(updateSlot);

            return updateSlot;
        }else{
           throw new profileAlreadyExists();

        }
        }

    @Override
    public InterviewerEntity deleteById(String slot_id)throws RecordNotFound {
        Optional < InterviewerEntity> slotid = this.interviewRepository.findById(slot_id);

        if (slotid.isPresent()) {
            this.interviewRepository.delete(slotid.get());
        } else {
            throw new RecordNotFound();
        }
          return null;
    }



    }



