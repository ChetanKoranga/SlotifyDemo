/*
author: chetan.koranga,
date of creation: 18/05/22
*/

package com.stackroute.controllers;

import com.stackroute.models.SlotUpdate;
import com.stackroute.services.TagService;
import com.stackroute.models.SlotsBooked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    // Get slots by interviewer emailId
    @GetMapping("/slot/interviewer/{email}")
    public ResponseEntity<?> slotByInterviewer(@PathVariable String email) {
        return new ResponseEntity<>(tagService.findByInterviewerEmailId(email), HttpStatus.OK);
    }

    // Get slots by TAG member emailId
    @GetMapping("/slot/tag/{email}")
    public ResponseEntity<?> slotByTag(@PathVariable("email") String email) {
        return new ResponseEntity<>(tagService.findByTagEmailId(email), HttpStatus.OK);
    }

//// Get interviewer by tech tack
//    @PostMapping("/interviewers")
//    public ResponseEntity<?> showInterviewers(){
//        return new ResponseEntity<>("Interviewers list", HttpStatus.OK);
//    }

    @PostMapping("/book-slot")
    public ResponseEntity<?> bookSlot(@RequestBody SlotsBooked slotData) {
        SlotsBooked slotsBooked = tagService.save(slotData);
        return new ResponseEntity<>(slotsBooked, HttpStatus.OK);
    }

    @PatchMapping("/update-slot")
    public ResponseEntity<?> updateSlot(@RequestBody SlotUpdate slotData) throws Exception {
        try {
            SlotsBooked slotsBooked = tagService.updateSlot(slotData);
            return new ResponseEntity<>(slotsBooked, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}