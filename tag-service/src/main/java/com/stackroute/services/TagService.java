package com.stackroute.services;
/*
author: chetan.koranga,
date of creation: 19/05/22
*/

import com.stackroute.exceptions.NotFoundException;
import com.stackroute.models.SlotUpdate;
import com.stackroute.models.SlotsBooked;

import java.util.List;

public interface TagService {

    List <SlotsBooked> findByTagEmailId(String email) throws NotFoundException;

    List<SlotsBooked> findByInterviewerEmailId(String email);

    SlotsBooked save(SlotsBooked data);

    SlotsBooked updateSlot(SlotUpdate data) throws Exception;


}