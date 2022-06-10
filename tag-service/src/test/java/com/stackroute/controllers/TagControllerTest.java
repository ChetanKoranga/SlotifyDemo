/*
author: chetan.koranga,
date of creation: 03/06/22
*/

package com.stackroute.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.models.Resume;
import com.stackroute.models.SlotStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import com.stackroute.models.SlotsBooked;
import com.stackroute.services.TagService;
import org.springframework.test.web.servlet.MockMvcBuilder;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class TagControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Mock
    TagService tagService;
    @InjectMocks
    TagController tagController;

    private SlotsBooked slotsBooked;
    private Resume resume;

    private List<SlotsBooked> slotsList;

    @BeforeEach
    public void setUp() {
        slotsBooked = slotsBooked.builder().slotId("abc123").interviewerEmailId("abc@gmail.com").interviewerName("ABC").tagEmailId("xyz@gmail.com").tagMemberName("XYZ").tagTeamName("TUV").candidateEmailId("cemail@gmail.com").candidateName("CName").candidateId("cid").slotStatus(SlotStatus.valueOf("BOOKED")).resume(resume.builder().fileName("fileName").fileSize(3214L).file("file").build()).bookedDate(new Date(2022, 06, 06)).startTime(new Date(2022, 06, 06)).endTime(new Date(2022, 06, 06)).notes("Note1").meetingVenue("Skype").meetingLink("Link123").build();
        mockMvc = MockMvcBuilders.standaloneSetup(tagController).build();
    }

    @AfterEach
    public void tearDown() {
        slotsBooked = null;
    }

    private String email = "chetankoranga@gmail.com";

    @Test
    void testBookSlot() throws Exception {
        when(tagService.save(any())).thenReturn(slotsBooked);
        mockMvc.perform(post("/api/v1/tagservice/book-slot")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonToString(slotsBooked)))
                .andExpect(status().isOk());
        ;
        verify(tagService, times(1)).save(any());
    }

    @Test
    void testUpdateSlot() throws Exception {
        when(tagService.updateSlot(any())).thenReturn(slotsBooked);
        mockMvc.perform(patch("/api/v1/tagservice/update-slot")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonToString(slotsBooked)))
                .andExpect(status().isOk());
        ;
        verify(tagService, times(1)).updateSlot(any());
    }

    @Test
    void slotByTag() throws Exception {
        when(tagService.findByTagEmailId(any())).thenReturn(slotsList);
        mockMvc.perform(get("/api/v1/tagservice/slot/tag/" + email)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonToString(slotsBooked)))
                .andExpect(status().isOk());
        verify(tagService, times(1)).findByTagEmailId(any());
    }

    @Test
    void slotByinterviewer() throws Exception {
        when(tagService.findByInterviewerEmailId(any())).thenReturn(slotsList);
        mockMvc.perform(get("/api/v1/tagservice/slot/interviewer/" + email)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonToString(slotsBooked)))
                .andExpect(status().isOk());
        ;
        verify(tagService, times(1)).findByInterviewerEmailId(any());
    }

    public static String jsonToString(final Object o) throws JsonProcessingException {
        String result;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonContent = mapper.writeValueAsString(o);
            result = jsonContent;
            return result;

        } catch (JsonProcessingException e) {
            result = "JsonProcessingException";
        }
        return result;
    }

}
