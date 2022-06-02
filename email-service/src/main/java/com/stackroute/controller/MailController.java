package com.stackroute.controller;
import com.stackroute.model.Email;
import com.stackroute.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class MailController {
        @Autowired
        private EmailService emailService;

        @RequestMapping("/Start")
        public String Welcome() {
            return "hello this is slotify Email api..";
        }

        @RequestMapping(value = "/sendemail", method = RequestMethod.POST)
        public ResponseEntity<?> sendEmail(@RequestBody Email email) {
            System.out.println(email);
            boolean result = this.emailService.sendEmail(email);
            if (result) {
                return ResponseEntity.ok("Email sent successfully:");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("email not sent");
            }
        }

    }

