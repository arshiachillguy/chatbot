package com.example.chatBot.Models;

public class ChatResponse {

    private String response;
    private String timestamp;


    public ChatResponse(String response, String timestamp) {
        this.response = response;
        this.timestamp = timestamp;
    }

    public ChatResponse() {

    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
