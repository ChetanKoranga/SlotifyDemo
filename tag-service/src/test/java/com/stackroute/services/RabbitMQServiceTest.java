/*
author: chetan.koranga,
date of creation: 09/06/22
*/

package com.stackroute.services;

import com.stackroute.exceptions.InternalServerException;
import com.stackroute.models.Resume;
import com.stackroute.models.SlotStatus;
import com.stackroute.models.SlotUpdate;
import com.stackroute.models.SlotsBooked;
import com.stackroute.publisher.EmailPublisher;
import com.stackroute.publisher.PublisherDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
public class RabbitMQServiceTest {
    @Mock
    RabbitTemplate template;
    @Mock
    PublisherDto publisherDto;

    @InjectMocks
    EmailPublisher emailPublisher;
    SlotsBooked slotsBooked;

    SlotUpdate slotUpdate;
    Resume resume;

    @BeforeEach
    public void setUp() {
        slotsBooked = slotsBooked.builder().slotId("abc123").interviewerEmailId("abc@gmail.com").interviewerName("ABC").tagEmailId("xyz@gmail.com").tagMemberName("XYZ").tagTeamName("TUV").candidateEmailId("cemail@gmail.com").candidateName("CName").candidateId("cid").slotStatus(SlotStatus.BOOKED).bookedDate(new Date()).startTime(new Date(2022, 06, 06)).endTime(new Date(2022, 06, 06)).resume(resume.builder().fileName("fileName").file("file").fileSize(3214L).build()).notes("Note1").meetingVenue("Skype").meetingLink("Link123").build();
        publisherDto = PublisherDto.builder().subject("Subject").interviername("ABC").intervierEmailId("intervierEmailId").tagmembername("XYZ").tagEmailId("xyz@gmail.com").candidatename("candidatename").candidateEmailId("cemail@gmail.com").messageText("messageText").startTime(new Date()).endTime(new Date()).date(new Date()).build();

        //        slotUpdate = SlotUpdate.builder().slotId("string").slotStatus(SlotStatus.BOOKED).meetingLink("Skype Link").meetingVenue("Skype").build();
//        publisherDto = PublisherDto.builder().subject("Subject").interviername("ABC").intervierEmailId("intervierEmailId").tagmembername("XYZ").tagEmailId("xyz@gmail.com").candidatename("candidatename").candidateEmailId("cemail@gmail.com").messageText("messageText").startTime(new Date()).endTime(new Date()).date(new Date()).build();
    }

    @Test
    void testRabbitMQService() throws Exception {
        Boolean sendSlotBookedDetails = emailPublisher.sendBookedSlotDetails(slotsBooked);
        assertThat(sendSlotBookedDetails).isTrue();
        Boolean sendSlotUpdateDetails = emailPublisher.sendUpdatedSlotDetails(slotsBooked);
        assertThat(sendSlotUpdateDetails).isTrue();
//        assertThat(sendSlotDetails).isEqualTo(new InternalServerException("Something went bad with the messaging queue. Please try again."));
    }
}