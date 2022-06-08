/*
author: chetan.koranga,
date of creation: 05/06/22
*/

package com.stackroute.services;

import com.stackroute.exceptions.InternalServerException;
import com.stackroute.models.Resume;
import com.stackroute.models.SlotStatus;
import com.stackroute.models.SlotUpdate;
import com.stackroute.models.SlotsBooked;
import com.stackroute.publisher.EmailPublisher;
import com.stackroute.publisher.PublisherDto;
import com.stackroute.repositories.TagRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Date;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
public class TagServiceTest {
    public static final String TAG_EMAIL = "String";
    public static final String INTERVIEWER_EMAIL = "String";
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TagRepo tagRepo;
    @Mock
    private EmailPublisher emailPublisher;
    @InjectMocks
    private TagServiceImpl tagService;

    SlotsBooked slotsBooked;
    SlotUpdate slotUpdate;
    Resume resume;


    List<SlotsBooked> slotsList;


    @BeforeEach
    public void setUp() {
        slotsBooked = slotsBooked.builder().slotId("abc123").interviewerEmailId("abc@gmail.com").interviewerName("ABC").tagEmailId("xyz@gmail.com").tagMemberName("XYZ").tagTeamName("TUV").candidateEmailId("cemail@gmail.com").candidateName("CName").candidateId("cid").slotStatus(SlotStatus.BOOKED).bookedDate(new Date()).startTime(new Date(2022, 06, 06)).endTime(new Date(2022, 06, 06)).resume(resume.builder().fileName("fileName").file("file").fileSize(3214L).build()).notes("Note1").meetingVenue("Skype").meetingLink("Link123").build();
        slotUpdate = SlotUpdate.builder().slotId("abc123").slotStatus(SlotStatus.BOOKED).meetingLink("Skype Link").meetingVenue("Skype").build();
//        publisherDto = PublisherDto.builder().subject("Subject").interviername("ABC").intervierEmailId("intervierEmailId").tagmembername("XYZ").tagEmailId("xyz@gmail.com").candidatename("candidatename").candidateEmailId("cemail@gmail.com").messageText("messageText").startTime(new Date()).endTime(new Date()).date(new Date()).build();
    }

    @AfterEach
    public void tearDown() {
        slotsBooked = null;
        slotUpdate = null;
    }


    // test for booking the new slot
    @Test
    void testBookSlot() throws Exception {
        when(tagService.save(slotsBooked)).thenReturn(slotsBooked).thenThrow(InternalServerException.class);
        when(emailPublisher.sendBookedSlotDetails(slotsBooked)).thenReturn(true);
        SlotsBooked savedSlot = tagService.save(slotsBooked);
        assertThat(savedSlot.getSlotId()).isNotNull();


    }

    //  test for updating the already booked slot
    @Test
    void testUpdateSlot() throws Exception {
        when(tagRepo.save(slotsBooked)).thenReturn(slotsBooked).thenThrow(InternalServerException.class);
        when(emailPublisher.sendBookedSlotDetails(slotsBooked)).thenReturn(true);
//        SlotsBooked savedSlot = tagService.updateSlot(slotUpdate);
//        assertThat(savedSlot.getSlotId()).isNotNull();
    }


    @Test
    void testFindSlotByTagEmail() throws Exception {
        when(tagRepo.findByTagEmailId(TAG_EMAIL)).thenReturn(slotsList).thenThrow(InternalServerException.class);
//        System.out.println(slotsList + "\n" + tagService.findByTagEmailId(TAG_EMAIL));
        assertEquals(slotsList, tagService.findByTagEmailId(TAG_EMAIL));
        verify(tagRepo, times(1)).findByTagEmailId(TAG_EMAIL);
    }

    @Test
    void testFindSlotByInterviewerEmail() throws Exception {

        when(tagRepo.findByInterviewerEmailId(INTERVIEWER_EMAIL)).thenReturn(slotsList);
        assertEquals(slotsList, tagService.findByInterviewerEmailId(INTERVIEWER_EMAIL));
    }
}