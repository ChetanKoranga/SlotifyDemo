package com.stackroute.interviewerservice;

import com.stackroute.interviewerservice.model.InterviewerEntity;
import com.stackroute.interviewerservice.model.SlotStatus;
import com.stackroute.interviewerservice.reprository.InterviewRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.util.List;

//import static java.util.concurrent.ForkJoinPool.WorkQueue.getSlot;
import static org.mockito.Mockito.doReturn;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@ExtendWith(SpringExtension.class)
@DataMongoTest

public class InterviewerRepositoryTest {
    @Autowired
    private InterviewRepository interviewRepository;

    private InterviewerEntity getSlot;


    @BeforeEach
    void setUp() throws ParseException {
        getSlot = new InterviewerEntity();
        getSlot.setSlot_id("");
        getSlot.setInterviewer_emailId("Pratapraju123@gmail.com");
        getSlot.setSlot_date("2022:09:22");
        getSlot.setStart_time("10:00:00");
        getSlot.setEnd_time("11:00:00");
        getSlot.setMeeting_venue("google meet");
        getSlot.setMeeting_link("https://meet.google.com/spk-xkxm-dig ");
        getSlot.setSlot_status(SlotStatus.BOOKED);

    }


    @AfterEach
    void tearDown() {

        getSlot =null;
    }


    @Test
    public void givenEmailThenShouldReturnRespectiveUser()throws Exception{

        InterviewerEntity interviewerEntity = interviewRepository.save(getSlot);
        List<InterviewerEntity> jobApplicationList = interviewRepository.findByInterviewerEmailId(getSlot.getInterviewer_emailId());
        Assertions.assertEquals(getSlot.getInterviewer_emailId(),jobApplicationList.get(0).getInterviewer_emailId());

    }





}

