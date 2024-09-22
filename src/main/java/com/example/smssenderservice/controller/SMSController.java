package com.example.smssenderservice.controller;

import com.example.smssenderservice.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class SMSController {
    @Autowired
    private SMSService smsService;

    @PostMapping("/send-otp")
    public ResponseEntity<String> sendOTP(@RequestBody Map<String, String> payload) {
        String contactId = payload.get("contactId");
        String message = payload.get("message");

        boolean success = smsService.sendSMS(contactId, message);

        if (success) {
            return ResponseEntity.ok("Message Sent");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Send Message");
        }
    }

    @GetMapping("/sent-messages")
    public List<Map<String, String>> getSentMessages() {
        return smsService.getSentMessages();
    }

}

