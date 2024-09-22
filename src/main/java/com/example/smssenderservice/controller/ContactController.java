package com.example.smssenderservice.controller;

import com.example.smssenderservice.model.Contact;
import com.example.smssenderservice.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public List<Contact> getContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/contacts/{id}")
    public Contact getContactById(@PathVariable String id) {
        return contactService.getContactById(id);
    }
}
