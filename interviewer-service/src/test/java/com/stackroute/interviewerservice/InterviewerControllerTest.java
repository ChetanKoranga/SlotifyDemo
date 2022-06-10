package com.stackroute.interviewerservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.interviewerservice.Exception.RecordNotFound;
import com.stackroute.interviewerservice.controller.InterviewController;
import com.stackroute.interviewerservice.model.InterviewerEntity;
import com.stackroute.interviewerservice.model.SlotStatus;
import com.stackroute.interviewerservice.service.InterviewService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(MockitoExtension.class)
public class InterviewerControllerTest {


        private MockMvc mockMvc;

        @Mock
        private InterviewService interviewService;

        private InterviewerEntity interviewerEntity;
        private List<InterviewerEntity> interviewList;

        @InjectMocks
        private InterviewController interviewController;


        @BeforeEach
        public void setUp() throws ParseException {
            interviewerEntity = new InterviewerEntity();
            interviewerEntity = new InterviewerEntity();
            interviewerEntity.setSlot_id("");
            interviewerEntity = new InterviewerEntity();
            interviewerEntity.setInterviewer_emailId("Pratapraju123@gmail.com");
            interviewerEntity.setSlot_date("2022:09:22");
            interviewerEntity.setStart_time("10:00:00");
            interviewerEntity.setEnd_time("11:00:00");
            interviewerEntity.setMeeting_venue("google meet");
            interviewerEntity.setMeeting_link("https://meet.google.com/spk-xkxm-dig ");
            interviewerEntity.setSlot_status(SlotStatus.BOOKED);
            //optional = Optional.of(fetchedSlot);
            interviewList = new ArrayList<>();
            interviewList.add(interviewerEntity);
            mockMvc = MockMvcBuilders.standaloneSetup(interviewController).build();
        }
        @AfterEach
        public void tearDown(){
            interviewerEntity = null;
        }

        @Test
        public void addingNewSlotTest() throws Exception {
            when(interviewService.createInterview(any())).thenReturn(interviewerEntity);
            mockMvc.perform(post("/api/v1").contentType(MediaType.APPLICATION_JSON).content(jsonToString(interviewerEntity)));

            verify(interviewService, times(1)).createInterview(interviewerEntity);

        }





        @Test
        public void findbyEmailIdTest() throws Exception{
            lenient().when(interviewService.getByInterviewerEmailId(interviewerEntity.getInterviewer_emailId())).thenReturn(interviewList);
            mockMvc.perform(get("/api/v1/Pratapraju123@gmail.com")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonToString(interviewerEntity)))
                    .andExpect(status().isImUsed()).andDo(MockMvcResultHandlers.print());
            Mockito.verify(interviewService, times(1)).getByInterviewerEmailId(any());

        }

        private List<InterviewerEntity> getSlot() {
            return  null;
        }


        @Test
        public void givenToUpdateTest() throws Exception {
            when(interviewService.updateInterview(any())).thenReturn(interviewerEntity);
            mockMvc.perform(put("/api/v1").contentType(MediaType.APPLICATION_JSON).content(jsonToString(interviewerEntity)))
                    .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
            verify(interviewService, times(1)).updateInterview(any());
        }



        @Test
        public void deleteByIdTest() throws Exception {
            when(interviewService.deleteById("630901")).thenReturn(interviewerEntity);
            mockMvc.perform(delete("/api/v1/630901"))
                    .andDo(MockMvcResultHandlers.print());
            verify(interviewService,times(0)).getByInterviewerEmailId(any());

        }






        private static String jsonToString(final Object o) throws JsonProcessingException {
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



