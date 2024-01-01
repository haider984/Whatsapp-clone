package com.sample.WhatsApp.clone.Service;

import com.sample.WhatsApp.clone.Entity.Contact;
import com.sample.WhatsApp.clone.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User saveUser(User user);

    public List<User> getAllUser();

    public Optional<User> getUserById(Long user_id);

    public User updateUser(Long userId, User user);

    public String addContact(Long userId, Long contactUserId);

    public List<Contact> getContactsByUserId(Long userId);
}
