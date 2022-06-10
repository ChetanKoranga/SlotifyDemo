package com.stackroute.controller;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.DTOs.TAGMemeberDto;
import com.stackroute.Models.Candidate;
import com.stackroute.Models.Interviewer;
import com.stackroute.Models.TAGMemeber;
import com.stackroute.controllers.userController;
import com.stackroute.repository.InterviewerRepo;
import com.stackroute.service.UserService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockRestServiceServer
public class UserControllerTest {


    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    private Interviewer interviewer;
    private List<Interviewer> interviewers;

    private TAGMemeber tagMemeber;
    private List<TAGMemeber> tagMemebers;



    private InterviewerRepo interviewerRepo;

    private Candidate candidate;
    private List<Candidate> candidates;

    @InjectMocks
    private userController usercontroller;

    @BeforeEach
    public void setUp(){
        interviewer =  new Interviewer("raju12@gmail.com" ,"raju","yadav",9989802412l,"raju@12");
        mockMvc = MockMvcBuilders.standaloneSetup(usercontroller).build();

        tagMemeber =  new TAGMemeber("raju@gmail.com" ,"harish", "vanga",9989802423L,"java");

    }


    @AfterEach
    public void tearDown(){
        interviewer =null;
        tagMemeber=null;

    }

    @Test
    public void giveninterviewerSavedinterviewer() throws Exception  {
        when(userService.registerInterviewer(any())).thenReturn(interviewer);
        mockMvc.perform(post("/api/v1/userservice/register-interviewer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(interviewer)))
                .andExpect(status().isCreated());
        verify(userService, times(1)).registerInterviewer(any());
    }




    @Test
    public void giventagmemberSavedtagmember() throws Exception {
        when(userService.registerTAGMember(any())).thenReturn(new TAGMemeberDto());
        mockMvc.perform(post("/api/v1/userservice/register-TAGMember")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(tagMemeber)))
                .andExpect(status().isCreated());
        verify(userService, times(1)).registerTAGMember(any());
    }


//    @BeforeEach
//    public void setUp2(){
//        candidate =  new Candidate("raju@gmail.com" ,"harish", "vanga",9989802423L,2.8,5.70,8.90,30,);
//        mockMvc = MockMvcBuilders.standaloneSetup(usercontroller).build();
//    }
//    @AfterEach
//    public void tearDown2(){
//        candidate =null;
//    }
//    @Test
//    public void givencandidateSavedcandidate() throws Exception {
//        when(userService.registerCandidate(any())).thenReturn(candidate);
//        mockMvc.perform(post("/api/v1/userservice/register-TAGMember")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(candidate)))
//                .andExpect(status().isCreated());
//        verify(userService, times(1)).registerCandidate(any());
//    }

//
//    @Test
//    public void addingNewinterviewer() throws Exception{
//        when(interviewerRepo.save(getSlotinterviwer)).thenReturn(getSlotinterviwer);
//        assertEquals(getSlotinterviwer,userService.updateInterviewer(getSlotinterviwer));
//
//    }

    @Test
    public void updateInterviewer() throws Exception {
        when(userService.updateInterviewer(any())).thenReturn(interviewer);
        mockMvc.perform(put("/api/v1/userservice/updateinterviewer").contentType(MediaType.APPLICATION_JSON).content(asJsonString(interviewer)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(userService, times(1)).updateInterviewer(any());
    }

    @Test
    public void updatetagmember() throws Exception {
        when(userService.updateTAGMember(any())).thenReturn(tagMemeber);
        mockMvc.perform(put("/api/v1/userservice/updatetagmember").contentType(MediaType.APPLICATION_JSON).content(asJsonString(tagMemeber)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(userService, times(1)).updateTAGMember(any());
//    }
//    @Test
//    public void getBytechTrack() throws Exception {
//        lenient().when(userService.getByTechTrack(interviewer.getTechTrack())).thenReturn(interviewers);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/findBytechtrack/FullStack")
//                        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(interviewer)))
//                .andDo(MockMvcResultHandlers.print());
//        Mockito.verify(userService, times(1)).getByTechTrack(any());
//    }
//
    }


    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
