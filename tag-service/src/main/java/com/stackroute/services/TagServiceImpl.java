/*
author: chetan.koranga,
date of creation: 19/05/22
*/

package com.stackroute.services;

import com.stackroute.models.SlotUpdate;
import com.stackroute.models.SlotsBooked;
import com.stackroute.repositories.SlotUpdateRepo;
import com.stackroute.repositories.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepo tagRepo;

    @Autowired
    SlotUpdateRepo slotUpdateRepo;


    @Override
    public List<SlotsBooked> findByTagEmailId(String tagEmailId) {
        return tagRepo.findByTagEmailId(tagEmailId);
    }

    @Override
    public List<SlotsBooked> findByInterviewerEmailId(String email) {
        return tagRepo.findByInterviewerEmailId(email);
    }

    @Override
    public SlotsBooked save(SlotsBooked data) {
        return tagRepo.save(data);
    }

    @Override
    public SlotsBooked updateSlot(SlotUpdate data) throws Exception {
        SlotsBooked avail;
        if (tagRepo.existsById(data.getSlotId())) {
            avail = tagRepo.findById(data.getSlotId()).get();
            avail.setSlotStatus(data.getSlotStatus());
            return tagRepo.save(avail);
        }
        throw new Exception("Slot is unavailable");
    }
}





