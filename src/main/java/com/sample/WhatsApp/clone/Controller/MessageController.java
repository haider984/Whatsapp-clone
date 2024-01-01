package com.sample.WhatsApp.clone.Controller;

import com.sample.WhatsApp.clone.DTO.MessageResponse;
import com.sample.WhatsApp.clone.Repository.MessageRepository;
import com.sample.WhatsApp.clone.Service.ChatService;
import com.sample.WhatsApp.clone.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

import java.time.LocalDateTime;

@RestController
public class MessageController {

//    @Autowired
//    private MessageRepository messageRepo;

    @Autowired
    private MessageService messageService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    @SendTo("/topic/messages/{chatId}")
    public Message receiveMessage(@Payload com.sample.WhatsApp.clone.Entity.Message message, @DestinationVariable Long chatId) {

        message.setTimeStamp(LocalDateTime.now());
        messageService.save((Message) message);

        messagingTemplate.convertAndSend("/topic/messages/" + chatId, message);

        return (Message) message;
    }
}

