package com.example.chatBot.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatRequest {
    @JsonProperty("message")
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
