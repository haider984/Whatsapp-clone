package com.sample.WhatsApp.clone.Service;

import com.sample.WhatsApp.clone.Entity.Contact;
import com.sample.WhatsApp.clone.Entity.User;
import com.sample.WhatsApp.clone.Repository.ContactRepository;
import com.sample.WhatsApp.clone.Repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long user_id){
        return userRepository.findById(user_id);
    }

    @Override
    public User updateUser(Long userId, User user){
        User UpdatedUser = userRepository.findById(userId).get();

        if(Objects.nonNull(user.getName()))
            UpdatedUser.setName(user.getName());

        if(Objects.nonNull(user.getEmail()))
            UpdatedUser.setEmail(user.getEmail());

        if(Objects.nonNull(user.getPassword()))
            UpdatedUser.setPassword(user.getPassword());

        if(Objects.nonNull(user.getPhone()))
            UpdatedUser.setPhone(user.getPhone());

        return userRepository.save(UpdatedUser);

    }
    @Override
    public String addContact(Long userId, Long contactUserId) {
        User user = userRepository.findById(userId).orElse(null);
        User contactUser = userRepository.findById(contactUserId).orElse(null);

        if (user == null || contactUser == null) {
            return "User or contact user not found";
        }

        Contact contact = new Contact();
        contact.setUser(user); // Set the user for the contact
        contact.setContactName(contactUser.getName());
        contact.setPhone(contactUser.getPhone());

        // Add the contact to the user's contacts list
        user.getContacts().add(contact);

        // Save the changes to the database
        contactRepository.save(contact);

        return "Contact Created";
    }

    @Override
    public List<Contact> getContactsByUserId(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return contactRepository.findByUser(user);
        }
        return Collections.emptyList(); // Return an empty list if the user is not found
    }




//
//@PersistenceContext
//private EntityManager entityManager;
//
//    @Transactional
//    @Override
//    public String addContact(Long userId, Long contactUserId) {
//
//
//        try {
//            // Your existing code
//            User user = userRepository.findById(userId).orElse(null);
//            User contactUser = userRepository.findById(contactUserId).orElse(null);
//
//            if (user == null || contactUser == null) {
//                // Handle the case where either user or contactUser doesn't exist
//                return "User or ContactUser not found";
//            }
//
//            Contact contact = new Contact();
//            contact.setUser(user);
//            contact.setContactName(contactUser.getName());
//            contact.setPhone(contactUser.getPhone());
//
//            // Add the contact to the user's list of contacts
//            user.getContacts().add(contact);
//
//            // Save both the user and the contact within the same transaction
//            userRepository.save(user);
//
//            entityManager.flush(); // Flush changes to the database
//
//            return "Contact Created";
//        } catch (Exception e) {
//            e.printStackTrace(); // Log the exception
//            return "An error occurred: " + e.getMessage();
//        }
//
//    }
//


}
