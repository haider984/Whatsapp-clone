package com.sample.WhatsApp.clone.Service;

import com.sample.WhatsApp.clone.Entity.Contact;
import com.sample.WhatsApp.clone.Entity.User;
import com.sample.WhatsApp.clone.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;
    @Override
    public Contact saveContact(Contact contact){
        return contactRepository.save(contact);
    }
}
