package com.stackroute;

import  com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.stackroute.controller.CandidateController;
import com.stackroute.exceptionhandler.NoSuchDataExistsException;
import com.stackroute.model.*;
import com.stackroute.services.CandidateServices;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(MockitoExtension.class)
public class CandidateControllerTest {

    @Autowired
    MockMvc mockMvc;



    @Mock
    private CandidateServices serv;
     JobApplication jobApplication1;
    private Job job;
    private List<JobApplication> jobApplicationList1;
    private List<Job> jobList;
    @InjectMocks
    CandidateController candidateController;
    @BeforeEach
    public  void setUp(){
        jobApplication1 =new JobApplication("1","2","ssdsd","vinayak","vinayak@gmail.com","2022-05-24","5 years","manish@gmail.com","6Lpa",false,Exam_Status.scheduled, Group_Discussion.scheduled, Interview.scheduled);
       mockMvc = MockMvcBuilders.standaloneSetup(candidateController).build();
       // job = new Job("",)
      job = new Job("","developer","backend","BE","java","2022-08-22","2022-09-23","manish@gmail.com","manish","TAg1","Active","Banglore","fulltime","5LPA");
     jobList =new ArrayList<>();
   jobList.add(job);
        jobApplicationList1=new ArrayList<>();
     jobApplicationList1.add(jobApplication1);
        mockMvc = MockMvcBuilders.standaloneSetup(candidateController).build();
    }
    @AfterEach
    public void tearDown(){
        jobApplication1 =null;
        job = null;
    }
    @Test
    public void CandidateControllertoSave() throws Exception{
        when(serv.saveapp(any())).thenReturn(jobApplication1);
        mockMvc.perform(post("/api/v1/jobApp")
                       .contentType(MediaType.APPLICATION_JSON)
                       .content(jsonToString(jobApplication1))).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        Mockito.verify(serv,times(1)).saveapp(( any()));
    }
    @Test

    public void JOBPostedCandidateController() throws Exception{
        when(serv.save(any())).thenReturn(job);
        mockMvc.perform(post("/api/v1/jobpost")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonToString(job))).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        Mockito.verify(serv,times(1)).save(( any()));
    }

    @Test
    public void testfindallJObPOSTEDController() throws Exception{
        when(serv.findAll()).thenReturn((List<Job>) jobList);
        mockMvc.perform(get("/api/v1/findall")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonToString(job)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        Mockito.verify(serv, times(1)).findAll();
    }

    @Test
    public void testfindbyEmailInterviewerController() throws Exception,NoSuchDataExistsException{
        lenient().when(serv.findByTagMemberEmailId(job.getTagMemberEmailId())).thenReturn(jobList);
        mockMvc.perform(get("/api/v1/postdjobs/manish@gmail.com")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(jsonToString(job)))

         .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        Mockito.verify(serv, times(1)).findByTagMemberEmailId(any());
    }
    @Test
    public void givenToUpdateThenShouldReturnUpdatedjobbApplication() throws Exception {
        when(serv.UpdateJobApplication(any())).thenReturn(jobApplication1);
        mockMvc.perform(put("/api/v1/Updatejobapp").contentType(MediaType.APPLICATION_JSON).content(jsonToString(jobApplication1)));
             //.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(serv, times(1)).UpdateJobApplication(any());
    }
    @Test
    public void givenToUpdateThenShouldReturnUpdatedjobbPosted() throws Exception {
        when(serv.UpdateJob(any())).thenReturn(job);
        mockMvc.perform(put("/api/v1/Updatejob").contentType(MediaType.APPLICATION_JSON).content(jsonToString(job)));
        //          .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(serv, times(1)).UpdateJob(any());
    }
    @Test
    public void testfindbyEmailJObAPPLICATIOn() throws Exception,NoSuchDataExistsException{
        lenient().when(serv.findBytagMemberEmailId(jobApplication1.getTagMemberEmailId())).thenReturn(jobApplicationList1);
        mockMvc.perform(get("/api/v1/jobApppostd/manish@gmail.com")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonToString(jobApplication1)))

          .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        Mockito.verify(serv, times(1)).findBytagMemberEmailId(any());
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