package com.example.smssenderservice.config;

import com.twilio.Twilio;
import com.twilio.http.TwilioRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioConfig {
    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String fromNumber;

    @Bean
    public TwilioRestClient twilioRestClient() {
        // Initialize Twilio with AccountSid and AuthToken
        Twilio.init(accountSid, authToken);

        // Return the TwilioRestClient instance
        return new TwilioRestClient.Builder(accountSid, authToken).build();
    }

    public String getAccountSid() {
        return accountSid;
    }

    public String getAuthToken() {
        return authToken;
    }

    public String getFromNumber() {
        return fromNumber;
    }
}
