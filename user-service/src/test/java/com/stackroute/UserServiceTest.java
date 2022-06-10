package com.stackroute;


import com.stackroute.DTOs.InterviewerDto;
import com.stackroute.Models.Interviewer;
import com.stackroute.Models.TAGMemeber;
import com.stackroute.repository.InterviewerRepo;
import com.stackroute.service.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest(classes={UserServiceTest.class})
public class UserServiceTest {

    @Mock
    private InterviewerRepo interviewerRepo;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    private Interviewer interviewer;
    private Optional optional;

    private List<Interviewer> getInterviewer;
private List<TAGMemeber> gettagmember;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);


        getInterviewer = new ArrayList<>();
        getInterviewer.add(new Interviewer("raju12@gmail.com","raju","yadavvv",9989802412l,"cricket"));
//        getInterviewer.setFirstName("Rajesh");
//        getInterviewer.setLastName("patra");
//        getInterviewer.setMobileNumber(9989593103l);
//        getInterviewer.setTechTrack("Java Full Stack Developers");
//        getInterviewer.setPassword("raje@234");


        optional = Optional.of(getInterviewer);

    }

    @AfterEach
    public void tearDown(){
        getInterviewer= null;
    }
//    @Test
//    public void giveninterviwerSaveinterviewer() throws Exception{
//        when(userServiceImpl.registerInterviewer(getInterviewer)).thenReturn(getInterviewer);
//        Assertions.assertEquals(getInterviewer,userServiceImpl.registerInterviewer(getInterviewer));
//        verify(interviewerRepo,times(1)).save(any());
//    }






}
