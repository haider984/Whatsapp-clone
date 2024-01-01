package com.sample.WhatsApp.clone.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String chatName; // Unique identifier for the chat

    @OneToMany(mappedBy = "chat")
    private List<Message> messages; // List of messages in the chat

    @ManyToMany
    private List<User> participants; // List of users participating in the chat

    public Chat() {
    }

    public Chat(Long id, String chatName, List<Message> messages, List<User> participants) {
        this.id = id;
        this.chatName = chatName;
        this.messages = messages;
        this.participants = participants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", chatName='" + chatName + '\'' +
                ", messages=" + messages +
                ", participants=" + participants +
                '}';
    }
}
