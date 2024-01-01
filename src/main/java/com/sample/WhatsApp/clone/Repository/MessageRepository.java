package com.sample.WhatsApp.clone.Repository;

import com.sample.WhatsApp.clone.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
