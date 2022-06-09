package com.stackroute;

import com.stackroute.controller.CandidateController;
import com.stackroute.exceptionhandler.DataAlreadyExistsException;
import com.stackroute.exceptionhandler.NoSuchDataExistsException;
import com.stackroute.model.*;
import com.stackroute.repositories.CandidateRepository;
import com.stackroute.repositories.JobRepositoy;
import com.stackroute.services.CandidateServicesIMPL;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.stackroute.model.Group_Discussion.not_scheduled;
import static com.stackroute.model.Interview.failed;
import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class CandidateServiceTest {

    @Autowired
    MockMvc mockMvc;

    private JobApplication jobApplication;
    private Job job;
    @Mock
    private JobRepositoy jobrepo;
    @InjectMocks
    CandidateController candidateController;

    @Mock
    private CandidateRepository repo;


    List<JobApplication> jobApplicationlist;

    List<Job> joblist;
    @InjectMocks
    private CandidateServicesIMPL serv;
   private Optional optional;

    @BeforeEach
    public void setUp() {

        jobApplication =new JobApplication("1l","2","developer","vinayak","vinayak@gmail.com", "24-05-2022","5 years","manish@gmail.com","6Lpa",false, Exam_Status.scheduled, Group_Discussion.scheduled, Interview.scheduled);

       job = new Job("","developer","backend","BE","java","2022-08-22","2022-09-23","manish@gmail.com","manish","TAg1","Active","Banglore","fulltime","5LPA");
        mockMvc = MockMvcBuilders.standaloneSetup(candidateController).build();
        joblist=new ArrayList<>();
        joblist.add(job);
        jobApplicationlist=new ArrayList<>();
                jobApplicationlist.add(jobApplication);
    }



    @AfterEach
    public void tearDown() {


        jobApplication = null;
       job = null;

    }

    @Test
    public void givenJobAPPlicationToSaveReturnSavedJobApplication() throws DataAlreadyExistsException {
        when(repo.findById(jobApplication.getApplicationId())).thenReturn(Optional.empty());
        when(repo.save(jobApplication)).thenReturn(jobApplication);
        assertEquals(jobApplication, serv.saveapp(jobApplication));
        verify(repo, times(1)).save(any());
        verify(repo, times(1)).findById(any());

    }
    @Test
    public void givenJobPostedToSaveReturnSavedJobPosted() throws DataAlreadyExistsException{
        when(jobrepo.findByJobTitle(job.getJobTitle())).thenReturn(Optional.empty());
        when(jobrepo.save(job)).thenReturn(job);
        assertEquals(job, serv.save(job));
        verify(jobrepo, times(1)).save(any());
        verify(jobrepo, times(1)).findByJobTitle(any());

    }



    @Test
    public void testServicefindall() throws NoSuchDataExistsException {
        //jobrepo.save(job);
        when(jobrepo.findAll()).thenReturn(joblist);
        assertEquals(joblist, serv.findAll());
       // verify(jobrepo, times(1)).save(job);
        verify(jobrepo, times(1)).findAll();

    }
//    @Test
//    public void testServicefindall(){
//        when(interviewerRepository.findAll()).thenReturn(interviewerSlotBookList);
//        assertEquals(interviewerSlotBookList,interviewerService.findall());
//        verify(interviewerRepository,times(1)).findAll();

//    @Test
//  public void givenUpdateThenShouldReturnUpdateJobApplication() {
//        when(serv.UpdateJobApplication(any())).thenReturn(jobApplication);
//       //jobApplication.getApplicationId();
//        //JobApplication jobb= repo.findById(jobApplication.getApplicationId()).get();
//
//        JobApplication update = serv.UpdateJobApplication(jobApplication);
//       // assertEquals(jobApplication,repo.save(jobApplication));
//        assertEquals(repo, update);
//
//    }
//@Test
//public void whenGivenId_shouldUpdateUser_ifFound() {
//    JobApplication jobapp = new JobApplication();
//
//    given(repo.findById(jobApplication.getApplicationId())).willReturn(Optional.of(jobApplication));
//    jobapp.setTagMemberEmailId("scv");
//    jobapp.setApplicationId("2");
//    verify(repo).save(jobapp);
//    assertEquals(repo,serv.UpdateJobApplication(jobapp));
//}








    @Test
    public void givenEmailIdToGetjobapplicationListThenReturnallJobapplication()throws NoSuchDataExistsException {
      try {
          when(repo.findByTagMemberEmailId(jobApplication.getTagMemberEmailId())).thenReturn(jobApplicationlist);

          assertEquals(jobApplicationlist, serv.findBytagMemberEmailId(jobApplication.getTagMemberEmailId()));
      }catch (NoSuchDataExistsException e){
          if(jobApplicationlist.isEmpty())
          throw new NoSuchDataExistsException("NO job registered to this email  or email doesnt exist");
      }

    }



    //
    @Test
    public void givenEmailIdToGetPOStedJOBThenReturnJOBposted()throws NoSuchDataExistsException {
        when(jobrepo.findByTagMemberEmailId(job.getTagMemberEmailId())).thenReturn(joblist);
        assertEquals(joblist,serv.findByTagMemberEmailId(job.getTagMemberEmailId()));

    }
}
