/*
author: chetan.koranga,
date of creation: 19/05/22
*/

package com.stackroute.services;

import com.stackroute.exceptions.InternalServerException;
import com.stackroute.exceptions.NotFoundException;
import com.stackroute.models.SlotStatus;
import com.stackroute.models.SlotUpdate;
import com.stackroute.models.SlotsBooked;
import com.stackroute.publisher.EmailPublisher;
import com.stackroute.repositories.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepo tagRepo;

    @Autowired
    EmailPublisher emailPublisher;


    // Service for getting slots by TAG member emailId
    @Override
    public List<SlotsBooked> findByTagEmailId(String tagEmailId) {
            return tagRepo.findByTagEmailId(tagEmailId);
    }

    // Service for getting slots by Interviewer emailId
    @Override
    public List<SlotsBooked> findByInterviewerEmailId(String email) {
        return tagRepo.findByInterviewerEmailId(email);
    }

    // Service for saving slot
    @Override
    public SlotsBooked save(SlotsBooked data) throws Exception {
            emailPublisher.sendBookedSlotDetails(data);
            return tagRepo.save(data);
    }

    // Service for updating a slot
    @Override
    public SlotsBooked updateSlot(SlotUpdate data) throws Exception {
        SlotsBooked avail;
//        System.out.println(tagRepo.findById(data.getSlotId()).toString());
        if (tagRepo.existsById(data.getSlotId())) {
            avail = tagRepo.findById(data.getSlotId()).get();
            avail.setSlotStatus(data.getSlotStatus());
            emailPublisher.sendUpdatedSlotDetails(avail);
            return tagRepo.save(avail);
        }
        throw new NotFoundException("No Slot found with the given id=" + data.getSlotId());
    }
}





