package com.stackroute;

import com.stackroute.model.*;
import com.stackroute.repositories.CandidateRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@ExtendWith(SpringExtension.class)
@DataMongoTest
public class CandidateRepositoryTest {
    @Autowired
    private CandidateRepository repo;

    private JobApplication jobApplication;
    private Job job;


    @BeforeEach
    public void setUp() {
        jobApplication =new JobApplication("","2","developer","vinayak","vinayak@gmail.com","2022-05-24" ,"5 years","manish@gmail.com","6Lpa",false, Exam_Status.scheduled, Group_Discussion.scheduled, Interview.scheduled);

        job = new Job("","javadeveloper","backend","BE","java","2022-08-22","2022-09-23","manish@g,ail.com","manish","TAg1","Active","Banglore","fulltime","5LPA");

//        product = new Product(2, "mobile", productDetails2);
//        productDetails2 = new ProductDetails(102, "samsung", 100);

    }

    @AfterEach
    public void tearDown() {
         jobApplication=null;

         repo.deleteAll();

    }

    @Test
    public void givenSlotToSaveShouldReturnSavedSlot(){
        repo.insert(jobApplication);
        JobApplication jobapp = repo.findById(jobApplication.getApplicationId()).get();
        Assertions.assertEquals(jobapp.getApplicationId(),jobApplication.getApplicationId());
    }

    @Test
    public void givenTrackReturnAllJobApplication() {
        repo.insert(jobApplication);

        List<JobApplication> list = repo.findAll();
        assertEquals(1, list.size());
        assertEquals("developer", list.get(0).getJobTitle());
    }

    @Test
    public void givenEmailThenShouldReturnRespectiveUser(){
        //JobApplication jobapp = new J("bala@gmail.com","Bala",UserRole.INTERVIEWER, 764774,"bala@123","FullStack");
        JobApplication jobapp = repo.save(jobApplication);
        List<JobApplication> jobApplicationList = repo.findByTagMemberEmailId(jobApplication.getTagMemberEmailId());
        assertEquals(jobApplication.getCandidate_name(),jobApplicationList.get(0).getCandidate_name());
        assertEquals(jobApplication.getApplicationId(),jobApplicationList.get(0).getApplicationId());
        assertEquals(jobApplication.getJobTitle(),jobApplicationList.get(0).getJobTitle());
        assertEquals(jobApplication.getCandidate_emailId(),jobApplicationList.get(0).getCandidate_emailId());
        assertEquals(jobApplication.getTagMemberEmailId(),jobApplicationList.get(0).getTagMemberEmailId());
//        assertEquals(user1.getDepartment(),optional.get().getDepartment());
//        assertEquals(user1.getPhoneNo(),optional.get().getPhoneNo());
//        assertEquals(user1.getPassword(),optional.get().getPassword());
    }

}
