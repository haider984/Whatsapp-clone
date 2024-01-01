package com.sample.WhatsApp.clone.Repository;

import com.sample.WhatsApp.clone.Entity.Contact;
import com.sample.WhatsApp.clone.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    public List<Contact> findByUser(User user);
}
