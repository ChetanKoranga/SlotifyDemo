/*
author: chetan.koranga,
date of creation: 18/05/22
*/

package com.stackroute.controllers;

import com.stackroute.exceptions.InternalServerException;
import com.stackroute.exceptions.NotFoundException;
import com.stackroute.models.SlotUpdate;
import com.stackroute.services.TagService;
import com.stackroute.models.SlotsBooked;
import com.stackroute.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
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
        try {
            return ResponseEntity.ok(new Response("SUCCESS", tagService.findByTagEmailId(email), ""));
        } catch (InternalServerException e) {
            throw new InternalServerException("Something bad happened");
        }

    }

    // Book Slot
    @PostMapping("/book-slot")
    public ResponseEntity<?> bookSlot(@RequestBody SlotsBooked slotData) {
        try{
            System.out.println("========== BOOKING BOOKING ==========="+ slotData);
            SlotsBooked slotsBooked = tagService.save(slotData);
            return new ResponseEntity<>(slotsBooked, HttpStatus.OK);
        }
        catch (InternalServerException e) {
            throw new InternalServerException("Something bad happened");
        }

    }

    // Update booked slot
    @PatchMapping("/update-slot")
    public ResponseEntity<?> updateSlot(@RequestBody SlotUpdate slotData) throws Exception {
        try {
            SlotsBooked slotsBooked = tagService.updateSlot(slotData);
            return new ResponseEntity<>(slotsBooked, HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new NotFoundException("Slot not found");
        }
        catch (InternalServerException e) {
            throw new InternalServerException("Something bad happened");
        }
    }
}