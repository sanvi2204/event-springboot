package com.sanvi.sdp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanvi.sdp.model.ContactForm;
import com.sanvi.sdp.repo.ContactFormRepository;

@Service
public class ContactFormService {

     @Autowired
    private ContactFormRepository repository;

    public ContactForm saveContactForm(ContactForm form) {
       
        return repository.save(form);
    }
    public  List<ContactForm> getContactinfo() {
       
        return repository.findAll();
    }
}
