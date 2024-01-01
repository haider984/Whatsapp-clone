package com.sample.WhatsApp.clone.Service;

import com.sample.WhatsApp.clone.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void save(Message message){
        messageRepository.save(new com.sample.WhatsApp.clone.Entity.Message(message));

    }


}
