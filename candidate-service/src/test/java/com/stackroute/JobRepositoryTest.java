package com.stackroute;

import com.stackroute.model.*;
import com.stackroute.repositories.CandidateRepository;
import com.stackroute.repositories.JobRepositoy;
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
public class JobRepositoryTest {
    @Autowired
    private JobRepositoy jobrepo;


    private Job job;




    @BeforeEach
    public void setUp() {

        job = new Job("","javadeveloper","backend","BE","java","2022-08-22","2022-09-23","manish@g,ail.com","manish","TAg1","Active","Banglore","fulltime","5LPA");



    }

    @AfterEach
    public void tearDown() {
        job=null;
        jobrepo.deleteAll();
    }





    @Test
    public void givenTAGTEAMEmailThenShouldReturnRespectiveJobposted(){
        //JobApplication jobapp = new J("bala@gmail.com","Bala",UserRole.INTERVIEWER, 764774,"bala@123","FullStack");
        Job jobpost = jobrepo.save(job);
        List<Job> joblist = jobrepo.findByTagMemberEmailId(job.getTagMemberEmailId());
        assertEquals(job.getJob_posting_id(),joblist.get(0).getJob_posting_id());
        assertEquals(job.getJobTitle(),joblist.get(0).getJobTitle());
        assertEquals(job.getJob_description(),joblist.get(0).getJob_description());

//        assertEquals(user1.getDepartment(),optional.get().getDepartment());
//        assertEquals(user1.getPhoneNo(),optional.get().getPhoneNo());
//        assertEquals(user1.getPassword(),optional.get().getPassword());
    }

}
