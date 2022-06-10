/*
author: chetan.koranga,
date of creation: 18/05/22
*/

package com.stackroute.controllers;

import com.stackroute.models.SlotUpdate;
import com.stackroute.services.TagService;
import com.stackroute.models.SlotsBooked;
import com.stackroute.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
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
        return ResponseEntity.ok(new Response("SUCCESS", tagService.findByInterviewerEmailId(email), ""));
    }

    // Get slots by TAG member emailId
    @GetMapping("/slot/tag/{email}")
    public ResponseEntity<?> slotByTag(@PathVariable("email") String email) {
        return ResponseEntity.ok(new Response("SUCCESS", tagService.findByTagEmailId(email), ""));
    }

    // Book Slot
    @PostMapping("/book-slot")
    public ResponseEntity<?> bookSlot(@RequestBody SlotsBooked slotData) throws Exception {
        System.out.println("========== BOOKING BOOKING ===========" + slotData);
        SlotsBooked slotsBooked = tagService.save(slotData);
        return ResponseEntity.ok(new Response("SUCCESS", slotsBooked, "Slot Booked Successfully"));
    }

    // Update booked slot
    @PatchMapping("/update-slot")
    public ResponseEntity<?> updateSlot(@RequestBody SlotUpdate slotData) throws Exception {
        SlotsBooked slotsBooked = tagService.updateSlot(slotData);
        return ResponseEntity.ok(new Response("SUCCESS", slotsBooked, "Slot Updated Successfully"));
    }
}