package com.stackroute.interviewerservice;


import com.stackroute.interviewerservice.Exception.RecordNotFound;
import com.stackroute.interviewerservice.Exception.interviewIdNotExists;
import com.stackroute.interviewerservice.Exception.profileAlreadyExists;
import com.stackroute.interviewerservice.model.InterviewerEntity;
import com.stackroute.interviewerservice.model.SlotStatus;

import com.stackroute.interviewerservice.reprository.InterviewRepository;
import com.stackroute.interviewerservice.service.InterviewService;
import com.stackroute.interviewerservice.service.InterviewServiceImp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import  static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockRestServiceServer

public class InterviewerServiceTest {
    @Mock
    private InterviewRepository interviewerRepo;
    @InjectMocks
    private InterviewServiceImp interviewService;
    private List<InterviewerEntity> interviewSlot;
    private InterviewerEntity interviewSlot1;
    private Optional optional;

    private InterviewerEntity getSlot;

    @BeforeEach
    public void setUp() throws ParseException {
        MockitoAnnotations.initMocks(this);
        getSlot = new InterviewerEntity();
        getSlot.setSlot_id("799594");
        getSlot.setInterviewer_emailId("Pratapraju123@gmail.com");
        getSlot.setSlot_date("2022-06-07");
        getSlot.setStart_time("12:00:00");
        getSlot.setEnd_time("2022:09:22");
        getSlot.setSlot_status(SlotStatus.BOOKED);
        getSlot.setMeeting_venue("Google meet");
        getSlot.setMeeting_link("https://meet.google.com/spk-xkxm-dig");
        optional = Optional.of(getSlot);
        interviewSlot = new ArrayList<>();
        interviewSlot.add(getSlot);
    }

    @AfterEach
    public void tearDown(){
        getSlot= null;
    }

    @Test
    public void addingNewSlotTest() throws interviewIdNotExists {
        when(interviewerRepo.save(getSlot)).thenReturn(getSlot);
        assertEquals(getSlot, interviewService.createInterview(getSlot));

    }

    @Test
    public void update_Interview_SlotTest() throws profileAlreadyExists {
        when(interviewerRepo.findById(getSlot.getSlot_id())).thenReturn(Optional.ofNullable(getSlot));
        getSlot.setInterviewer_emailId("raju123@gmail.com");
        getSlot.setSlot_date("2022:06:4");
        getSlot.setStart_time("10:00:00");
        getSlot.setEnd_time("11:00:00");
        getSlot.setMeeting_venue("google meet");
        getSlot.setMeeting_link("https://meet.google.com/spk-xkxm-dig ");
        getSlot.setSlot_status(SlotStatus.BOOKED);
        InterviewerEntity schedulseeasy = interviewService.updateInterview(getSlot);
        assertEquals(getSlot, schedulseeasy);
    }


    @Test
    public void getByInterviewerEmailIdTest() {
        when(interviewerRepo.findByInterviewerEmailId(getSlot.getInterviewer_emailId())).thenReturn(interviewSlot);
        assertEquals(interviewSlot,interviewService.getByInterviewerEmailId(getSlot.getInterviewer_emailId()));

    }


    @Test
    public void deleteByIdTest() throws  RecordNotFound {
        when(interviewerRepo.findById(getSlot.getSlot_id())).thenReturn((optional));
        InterviewerEntity delete = interviewService.deleteById(getSlot.getSlot_id());
        Assertions.assertNotNull(getSlot);

    }
}


