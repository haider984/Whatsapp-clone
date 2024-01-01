package com.sample.WhatsApp.clone.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long senderID;

    private Long ReceiverID;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime timeStamp;

    @ManyToOne
    private Chat chat;

    public Message(org.springframework.messaging.Message message) {
    }

    public Message(Long id, Long senderID, Long receiverID, String content, LocalDateTime timeStamp, Chat chat) {
        this.id = id;
        this.senderID = senderID;
        ReceiverID = receiverID;
        this.content = content;
        this.timeStamp = timeStamp;
        this.chat = chat;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", senderID=" + senderID +
                ", ReceiverID=" + ReceiverID +
                ", content='" + content + '\'' +
                ", timeStamp=" + timeStamp +
                ", chat=" + chat +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderID() {
        return senderID;
    }

    public void setSenderID(Long senderID) {
        this.senderID = senderID;
    }

    public Long getReceiverID() {
        return ReceiverID;
    }

    public void setReceiverID(Long receiverID) {
        ReceiverID = receiverID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }
}
