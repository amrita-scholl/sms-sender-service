package com.example.smssenderservice.service;

import com.example.smssenderservice.config.TwilioConfig;
import com.twilio.Twilio;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SMSService {
    @Autowired
    private TwilioRestClient twilioRestClient;

    @Autowired
    private TwilioConfig twilioConfig;

//    public SMSService() {
//        // Initialize Twilio with the SID and Auth Token
//        Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
//    }

    private List<Map<String, String>> sentMessages = new ArrayList<>();

    public boolean sendSMS(String contactId, String message) {
        try {
            String toPhoneNumber = getContactPhoneNumberById(contactId);
            Message.creator(
                    new PhoneNumber(toPhoneNumber),
                    new PhoneNumber(twilioConfig.getFromNumber()),
                    message
            ).create();

            // Log message sent
            Map<String, String> sentMessage = new HashMap<>();
            sentMessage.put("contactId", contactId);
            sentMessage.put("message", message);
            sentMessage.put("time", LocalDateTime.now().toString());
            sentMessages.add(sentMessage);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Map<String, String>> getSentMessages() {
        return sentMessages;
    }

    private String getContactPhoneNumberById(String contactId) {
        // Assume logic to fetch phone number by contact ID
        if (contactId.equals("1")) return "+919000000000";
        if (contactId.equals("2")) return "+919000000000";
        return null;
    }
}
