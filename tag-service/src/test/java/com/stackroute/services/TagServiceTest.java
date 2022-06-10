/*
author: chetan.koranga,
date of creation: 05/06/22
*/

package com.stackroute.services;


import com.stackroute.models.Resume;
import com.stackroute.models.SlotStatus;
import com.stackroute.models.SlotsBooked;
import com.stackroute.repositories.TagRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class TagServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TagRepo tagRepo;
    @InjectMocks
    private TagServiceImpl tagService;


    SlotsBooked slotsBooked;
    Resume resume;

    @BeforeEach
    public void setUp() {
//        slotsBooked = new SlotsBooked("","abc@gmail.com","ABC","xyz@gmail.com","XYZ","TUV","cid1","CName","cemail@gmail.com", new Date(2022,06,06),"CANCELLED",new Date(2022,06,06),new Date(2022,06,06));
        slotsBooked = slotsBooked.builder().slotId("abc123").interviewerEmailId("abc@gmail.com").interviewerName("ABC").tagEmailId("xyz@gmail.com").tagMemberName("XYZ").tagTeamName("TUV").candidateEmailId("cemail@gmail.com").candidateName("CName").candidateId("cid").slotStatus(SlotStatus.BOOKED).resume(resume.builder().fileName("fileName").fileSize(3214L).file("file").build()).bookedDate(new Date()).startTime(new Date(2022, 06, 06)).endTime(new Date(2022, 06, 06)).notes("Note1").meetingVenue("Skype").meetingLink("Link123").build();
        mockMvc = MockMvcBuilders.standaloneSetup(tagService).build();
    }

    @AfterEach
    public void tearDown() {
        slotsBooked = null;
    }


    @Test
    void testBookSlot() throws Exception {
        // given - precondition or setup
//        given(tagRepo.findById(slotsBooked.getSlotId()))
//                .willReturn(Optional.empty());

        when(tagRepo.save(slotsBooked)).thenReturn(slotsBooked);

        System.out.println(tagRepo);
        System.out.println(tagService);
        System.out.println(slotsBooked);

        // when -  action or the behaviour that we are going test
        SlotsBooked savedSlot = tagService.save(slotsBooked);

        System.out.println("I reached to the last :    " + savedSlot);
        // then - verify the output
        assertThat(savedSlot).isNotNull();

    }

}