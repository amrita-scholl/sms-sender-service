package com.example.smssenderservice.service;

import com.example.smssenderservice.model.Contact;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ContactService {
    private List<Contact> contacts;

    public ContactService() {
        // Load contacts from a static JSON or initialize them
        contacts = Arrays.asList(
                new Contact("1", "A", "S", "+919000000000"),
                new Contact("2", "X", "Y", "+919000000000")
        );
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }

    public Contact getContactById(String id) {
        return contacts.stream().filter(contact -> contact.getId().equals(id)).findFirst().orElse(null);
    }
}

