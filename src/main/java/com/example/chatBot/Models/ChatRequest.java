package com.example.chatBot.Models;

public class ChatRequest {
    private String message;

    public ChatRequest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ChatRequest(){}
}
