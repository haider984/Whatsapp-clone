package com.sample.WhatsApp.clone.DTO;

import java.time.LocalDateTime;

public class MessageResponse {
    private Long senderId;
    private String content;
    private LocalDateTime timestamp;

    public MessageResponse() {
    }

    public MessageResponse(Long senderId, String content, LocalDateTime timestamp) {
        this.senderId = senderId;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
