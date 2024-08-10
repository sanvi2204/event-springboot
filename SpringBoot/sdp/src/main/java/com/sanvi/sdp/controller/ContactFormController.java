package com.sanvi.sdp.controller;


import com.sanvi.sdp.model.ContactForm;
import com.sanvi.sdp.service.ContactFormService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/contact")
 @CrossOrigin(origins = "http://localhost:5173")
public class ContactFormController {

    @Autowired
    private ContactFormService service;

    @PostMapping("/submit")
    public ContactForm submitContactForm(@RequestBody ContactForm form) {
        return service.saveContactForm(form);
    }
    @GetMapping("/getContactinfo")
    public List<ContactForm> getContactinfo() {
        return service.getContactinfo();
    }
    
}
